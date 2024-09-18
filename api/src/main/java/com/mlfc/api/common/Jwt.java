package common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import pojo.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Jwt {

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
    public void OutJwt(){

        String token = "";

        JwsHeader jwsHeader = Jwts
                .parser()
                .setSigningKey("lizhyuli")
                .parseClaimsJws(token)
                .getHeader();

        Claims claims = Jwts
                .parser()
                .setSigningKey("lizhyuli")
                .parseClaimsJws(token)
                .getBody();

        String signature = Jwts
                .parser()
                .setSigningKey("lizhyuli")
                .parseClaimsJws(token)
                .getSignature();


    }
}
