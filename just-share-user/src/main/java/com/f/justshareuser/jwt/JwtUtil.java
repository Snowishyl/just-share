package com.f.justshareuser.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    // 建议使用 256 位密钥
    private static final String SECRET = "feiwoscun-cqupt-feiwoscun-feiwoscun"; // 长度必须符合要求
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    // Token 过期时间（毫秒）
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1小时

    // 生成 Token
    public static String generateToken(String subject, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // 解析 Token
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 判断 Token 是否过期
    public static boolean isTokenExpired(String token) {
        try {
            Claims claims = parseToken(token);
            return claims.getExpiration().before(new Date());
        } catch (JwtException e) {
            return true;
        }
    }

    // 获取用户名（subject）
    public static String getSubject(String token) {
        return parseToken(token).getSubject();
    }
}
