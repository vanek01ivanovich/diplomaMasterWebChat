package com.diploma.master.demo.dao.impl;

import com.diploma.master.demo.dao.UserDao;
import com.diploma.master.demo.mapper.UserMapper;
import com.diploma.master.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;


    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    private final String FIND_USER_BY_EMAIL = "select user_id,username, password, name, surname, email, role from users where email = ?";
    private final String INSERT_NEW_USER = "insert into users (user_id,username,name,email,password,role,surname) values(?,?,?,?,?,?,?)";
    private final String GET_ALL_USERS = "select * from users";
    private final String GET_USER_BY_ID = "select * from users where user_id = ?";
    private final String CHECK_IF_USER_NAME_EXIST = "select count(*) from  users where username = ?";

    @Override
    public Optional<User> getUserByID(Integer id) {
        User user = jdbcTemplate.queryForObject(GET_USER_BY_ID, userMapper, id);
        return null;
    }

    @Override
    public User findUserByUserName(String username) {
        log.info("findUserByUserName");
        try {
            log.info("findUserByUserName {}", username);
            //return jdbcTemplate.queryForObject(Constants.FIND_USER_BY_EMAIL,userMapper,username);
            return jdbcTemplate.queryForObject(FIND_USER_BY_EMAIL, userMapper, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public void insertUser(User user) {
        log.info("insertUser");
        try {
            jdbcTemplate.update(INSERT_NEW_USER,
                    user.getId(),user.getUsername(),user.getName(),user.getEmail(),user.getPassword(),user.getRole(),user.getSurname());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public Boolean checkIfUserNameExists(String username) {
        Integer count = jdbcTemplate.queryForObject(CHECK_IF_USER_NAME_EXIST, Integer.class, username);
        return count != null && count != 0;
    }
}
