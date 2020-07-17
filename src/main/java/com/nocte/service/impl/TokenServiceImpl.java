package com.nocte.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nocte.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl {

    public String getToken(User user){
        String token="";
        token= JWT.create().withAudience(user.getId()) // 将 user id 保存到 token 里面
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .sign(Algorithm.HMAC256(user.getHashed_password()));// 以 password 作为 token 的密钥
        return token;
    }
}
