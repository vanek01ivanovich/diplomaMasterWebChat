package com.diploma.master.demo.dao;

import com.diploma.master.demo.model.User;

public interface UserDao {

    User findUserByUserName(String username);
}
