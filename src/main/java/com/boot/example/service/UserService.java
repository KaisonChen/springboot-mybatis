package com.boot.example.service;

import com.boot.example.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User getUserByUserName(String userName);

}
