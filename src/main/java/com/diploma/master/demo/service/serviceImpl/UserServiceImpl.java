package com.diploma.master.demo.service.serviceImpl;

import com.diploma.master.demo.dao.UserDao;
import com.diploma.master.demo.model.User;
import com.diploma.master.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserById(Integer id) {
        //return userDao.getUserByID(id);
        return null;
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findUserByUserName(email);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public Boolean checkIfUserNameExists(String username) {
        return userDao.checkIfUserNameExists(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
