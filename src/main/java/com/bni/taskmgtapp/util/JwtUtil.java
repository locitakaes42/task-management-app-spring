package com.bni.taskmgtapp.util;

import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;


@Service
public class JwtUtil {
    private static final String SECRET= "thisisasecretkeyacoyasjklaashdaskdjasjdlasjdljl";
    private static final Key SIGNING_KEY = new SecretKeySpec(
        Base64.getDecoder().decode(SECRET), SignatureAlgorithm.HS256.getJcaName());
    public String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SIGNING_KEY)
                .compact();
    }

    public String ValidateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SIGNING_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}