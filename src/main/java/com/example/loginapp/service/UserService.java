package com.example.loginapp.service;

import com.example.loginapp.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
