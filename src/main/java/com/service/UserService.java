package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

    User getUserById(Long id);
    
    List<User> getAllUsers();
    
    Long createUser(String name);
}
