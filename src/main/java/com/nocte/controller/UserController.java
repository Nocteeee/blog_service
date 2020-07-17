package com.nocte.controller;

import com.alibaba.fastjson.JSONObject;
import com.nocte.annotation.PassToken;
import com.nocte.annotation.UserLoginToken;
import com.nocte.pojo.User;
import com.nocte.service.impl.TokenServiceImpl;
import com.nocte.service.impl.UserServiceImpl;
import com.nocte.utils.RestCode;
import com.nocte.utils.RestResponse;
import com.nocte.utils.RestResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private TokenServiceImpl tokenServiceImpl;

    @GetMapping("getList")
    @UserLoginToken
    public RestResponse<List<User>> queryUserList(){
        RestResponse<List<User>> response = null;
        response = RestResponseUtil.success(userServiceImpl.queryUserList());
        return response;
    }

    @GetMapping("getById")
    @UserLoginToken
    public RestResponse<Object> queryUserById(String id){
        RestResponse<Object> response = null;
        response = RestResponseUtil.success(userServiceImpl.queryUserById(id));
        return response;
    }

    @PostMapping("add")
    @UserLoginToken
    public RestResponse<Object> addUser(User user){
        RestResponse<Object> response = null;
        response = RestResponseUtil.success(userServiceImpl.addUser(user));
        return response;
    }

    @PostMapping("update")
    @UserLoginToken
    public RestResponse<Object> updateUser(User user){
        RestResponse<Object> response = null;
        response = RestResponseUtil.success(userServiceImpl.updateUser(user));
        return response;
    }

    @PostMapping("delete")
    @UserLoginToken
    public RestResponse<Object> deleteUser(int id){
        RestResponse<Object> response = null;
        response = RestResponseUtil.success(userServiceImpl.deleteUser(id));
        return response;
    }

    @GetMapping("login")
    @PassToken
    public RestResponse<Object> login(String username, String password){
        RestResponse<Object> response = null;

        JSONObject jsonObject = new JSONObject();

        User userForBase=  userServiceImpl.queryUserByName(username);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            response = RestResponseUtil.error(401,"登录失败,用户不存在");
        }else {
            if (!userForBase.getHashed_password().equals(password)){
                jsonObject.put("message","登录失败,密码错误");
                response = RestResponseUtil.error(401,"登录失败,密码错误");
            }else {
                String token = tokenServiceImpl.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                response = RestResponseUtil.createResponse(RestCode.SUCCESS,jsonObject);
            }
        }

        return response;
    }
}
