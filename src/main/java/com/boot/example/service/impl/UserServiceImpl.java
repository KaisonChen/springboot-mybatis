package com.boot.example.service.impl;

import com.boot.example.dao.UserMapper;
import com.boot.example.pojo.User;
import com.boot.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* User: kaison
 * \* Date: 2017/12/26
 * \* Time: 15:15
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }
}
