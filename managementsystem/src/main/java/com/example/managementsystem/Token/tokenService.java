package com.example.managementsystem.Token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.managementsystem.Entity.User;

import java.util.Date;

public class tokenService {
    public static String getToken(User user){
        String token="";

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        long expMillis = nowMillis + 60*1000;
        Date exp = new Date(expMillis);

        token= JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;

    }
}
