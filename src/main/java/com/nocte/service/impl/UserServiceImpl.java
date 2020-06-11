package com.nocte.service.impl;

import com.nocte.mapper.UserMapper;
import com.nocte.pojo.User;
import com.nocte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public User login(String username ,String password){
        return userMapper.login(username,password);
    }

    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }

    public User queryUserById(String id){
        return userMapper.queryUserById(id);
    }

    public int addUser(User user){
        return userMapper.addUser(user);
    }

    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    public int deleteUser(int id){
        return userMapper.deleteUser(id);
    }

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
