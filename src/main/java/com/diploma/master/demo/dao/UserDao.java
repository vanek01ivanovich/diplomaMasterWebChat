package com.diploma.master.demo.dao;

import com.diploma.master.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> getUserByID(Integer id);

    User findUserByUserName(String username);

    User findUserByEmail(String email);

    Integer insertUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    Boolean checkIfUserNameExists(String username);

    Boolean checkIfEmailExists(String email);
}
