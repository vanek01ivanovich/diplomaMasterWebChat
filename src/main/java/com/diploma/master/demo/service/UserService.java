package com.diploma.master.demo.service;

import com.diploma.master.demo.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    Integer insertUser(User user);

    User getUserByEmail(String email);

    void updateUser(User user);

    Boolean checkIfUserNameExists(String username);

    Boolean checkIfEmailExists(String email);

    List<User> getAllUsers();
}
