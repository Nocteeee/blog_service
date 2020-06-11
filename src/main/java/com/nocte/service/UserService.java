package com.nocte.service;

import com.nocte.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public User login(String username , String password);

    public List<User> queryUserList();

    public User queryUserById(String id);

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);

    User queryUserByName(String username);
}
