package com.diploma.master.demo.dao.impl;

import com.diploma.master.demo.dao.UserDao;
import com.diploma.master.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User findUserByUserName(String username) {
        return null;
    }
}
