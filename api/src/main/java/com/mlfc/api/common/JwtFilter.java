package com.mlfc.api.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil; // 注入 JwtUtil


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("拦截请求：{}", request.getRequestURI());
        if (request.getRequestURI().contains("/fangyuan")) {
            log.info("登录请求，放行");
            filterChain.doFilter(request, response); // 继续链式调用
            return;
        }

        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
            return;
        }

        token = token.substring(7); // 去掉 "Bearer " 前缀

        try {
            // 解析 JWT
            String secretKey = "306"; // 可以从配置中读取
            Claims claims = jwtUtil.parseJWT(secretKey, token); // 使用实例方法
            if (claims == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
                return;
            }
            // 可以在这里设置用户信息到请求中
            request.setAttribute("claims", claims);
        } catch (JwtException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expired or invalid");
            return;
        }

        // 继续执行后续过滤器
        filterChain.doFilter(request, response);
    }
}
