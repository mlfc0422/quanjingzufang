//package com.mlfc.yonghu.consumer.controller;
//
//
//import com.mlfc.api.apiservice.RootService;
//import com.mlfc.api.common.Rest;
//import com.mlfc.api.pojo.Root;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.dubbo.config.annotation.DubboReference;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Slf4j
//@RestController
//@RequestMapping("test")
//public class TestController {
//
////    @Autowired
////    private JwtUtil jwtUtil;
//
//    @DubboReference
//    private RootService rootService;
//
//
//    @PostMapping("/login")
//    public Rest<String> login(@RequestBody Root root) {
//        log.info("RootLogin: {}", root);
//        Boolean result = rootService.login(root);
//        if (result == null) {
//            return Rest.error("登录失败");
//        }
//        log.info("登录成功");
//        // 假设用户验证成功，生成 JWT
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("account", root.getAccount());
//        // 添加其他自定义声明，例如用户角色等
//
//        // 生成 JWT，假设 secretKey 和 ttlMillis 已经定义
//        String secretKey = "306"; // 应该从配置文件中读取
//        long ttlMillis = 3600000; // 1小时
//
//        String token = jwtUtil.createJwt(secretKey, ttlMillis, claims); // 生成 JWT
//        log.info("生成的 JWT：{}", token);
//        return Rest.success(token);
//    }
//}
