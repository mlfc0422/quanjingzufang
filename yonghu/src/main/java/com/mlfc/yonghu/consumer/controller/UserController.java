package com.mlfc.yonghu.consumer.controller;

import apiserrvice.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mlfc.yonghu.provider.mapper.UserMapper;
import common.Jwt;
import common.Rest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import pojo.User;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("users")
@RestController
@Slf4j
public class UserController {

    @DubboReference
    private UserService userService;

    //用户登录
    @GetMapping("username")
    public Rest<User> UserLogin(@RequestBody User user){

        String id2=userService.selectId(user.getUserName(),user.getPassword());

        //判断密码是否正确
        if (id2 != null){
            return CreateJwt(user);
        }
        return null;
    }


    //用户注册
    @PostMapping
    public Rest<User> UserInsert(@RequestBody User user) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();//查询条件
        User id2 = userService.getOne(wrapper.select("id")
                .eq("userName", user.getUserName()));

        if (id2.getId() == null) {
            userService.save(user);
        }
        else {
            String msg = "用户已注册";
            return Rest.error(msg);
        }
        return null;
    }

    //用户查询
    @GetMapping("{id}")
    public Rest<User> UserGet(@RequestBody User user,@RequestBody long params){

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        if(params == user.getId()){
            user = userService.getById(user.getId());}
        else {
            userService.getOne(wrapper.select("userName","account","address","gender","age")
                    .eq("id",user.getId()));
        }
        return Rest.success(user);
    }

    //用户管理
    @PutMapping("/{id}/update")
    public void UserUpdate(@RequestBody User user){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        userService.update(user,wrapper.eq("id",user.getId()));

    }

    //生成令牌
    public Rest<User> CreateJwt(User user){

        //设置header
        Map<String, Object> header = new HashMap<>();
        header.put("alg","HS256");
        header.put("typ","JWT");

        //设置paylo
        Map<String,Object> payload = new HashMap<>();
        payload.put("userName",user.getUserName());
        payload.put("id",user.getId());

        //设置失效时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,60*60*24*7);

        //生成token
        user.setToken(Jwts.builder()
                .setHeader(header)
                .setClaims(payload)
                .setExpiration(instance.getTime())
                .signWith(SignatureAlgorithm.HS256,"lizhyuli")
                .compact());

        return Rest.success(user);
    }

    //  解码令牌
    //获取header
    public JwsHeader getHeaderFromToken(User user){

        JwsHeader jwsHeader = Jwts
                .parser()
                .setSigningKey("lizhyuli")
                .parseClaimsJws(user.getToken())
                .getHeader();

        return jwsHeader;
    }

    //获取claims
    public Claims getClaimsFromToken(User user) {

        Claims claims = null;
        try {
            claims = Jwts
                    .parser()
                    .setSigningKey("lizhyuli")
                    .parseClaimsJws(user.getToken())
                    .getBody();
        }catch (Exception e) {
        }
        return claims;
    }

    //获取signature
    public String getSignatureFromToken(User user){

        String signature = Jwts
                .parser()
                .setSigningKey("lizhyuli")
                .parseClaimsJws(user.getToken())
                .getSignature();

        return signature;
    }

    //获取token时间
    public Date getExpiredDateFromToken(User user){

        Claims claims = getClaimsFromToken(user);
        return claims.getExpiration();
    }

    //判断token是否失效
    public boolean isTokenExpired(User user){

        Date date = getExpiredDateFromToken(user);
        return date.before(new Date());
    }

    //判断令牌是否有效
    public boolean VerifyJwt(User user){

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        User userdata = userService.getOne(wrapper
                .select("id","userName")
                .eq("token",user.getToken()));

        String id = (String) getClaimsFromToken(user).get("id");
        String username = (String) getClaimsFromToken(user).get("userName");

        return id.equals(userdata.getId())
                && username.equals(userdata.getUserName())
                && !isTokenExpired(user);
    }

}
