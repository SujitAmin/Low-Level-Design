package com.example.restfulwebservices.user.service;

import com.example.restfulwebservices.user.dao.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User addUser(User user);
    User findUserById(int id);
    User deleteById(int id);
}

