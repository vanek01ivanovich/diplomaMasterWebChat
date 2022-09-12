package com.diploma.master.demo.service;

import com.diploma.master.demo.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    void insertUser(User user);

    User getUserByEmail(String email);

    void updateUser(User user);

    Boolean checkIfUserNameExists(String username);

    List<User> getAllUsers();
}
