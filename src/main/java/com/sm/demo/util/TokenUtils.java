package com.sm.demo.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 
import java.util.Map;
 
@Component
public class TokenUtils {
 
    // 令牌密钥
    @Value("${token-secret}")
    private String secret;
 
    // 生成Token令牌，传递用户信息
    public String createToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }
 
    // 解析Token令牌，获取用信息
    public Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
 
}
