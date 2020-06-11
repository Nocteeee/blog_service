package com.nocte.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nocte.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("TokenService")
public interface TokenService {

    public String getToken(User user);
}
