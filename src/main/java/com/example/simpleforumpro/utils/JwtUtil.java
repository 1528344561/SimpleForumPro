package com.example.simpleforumpro.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    //黑马这里没加static ,加了有没有影响?
//    @Test
//    public void testGen(){
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("id",1);
//        claims.put("username","张三");
//        JWT.create()
//                .withClaim("user",claims)
//                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))
//                .sign(Algorithm.HMAC256("I_LOVE_SDUST"));
//
//    }
    private static final String KEY = "I_LOVE_SDUST";
    public static String genToken(Map<String,Object> claims){
        return JWT.create()
                .withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24*20))
                .sign(Algorithm.HMAC256(KEY));
    }

    public static Map<String,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }

}
