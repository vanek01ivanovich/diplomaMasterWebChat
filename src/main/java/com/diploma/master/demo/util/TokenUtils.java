package com.diploma.master.demo.util;

import com.diploma.master.demo.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;

public class TokenUtils {
    private final String RESET_SECRET = "jf3e8aspol2c";
    private final String RESET_SECRET_ENC = Base64.getEncoder().encodeToString(RESET_SECRET.getBytes());


    public String generatePasswordResetToken(User user){
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setExpiration(new Date((new Date()).getTime() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS512, RESET_SECRET_ENC)
                .compact();
    }
}
