package com.nocte.mapper;

import com.nocte.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(String id);

    User login(String username,String password);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    User queryUserByName(String username);
}
