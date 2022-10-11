package com.diploma.master.demo.dao.impl;

import com.diploma.master.demo.constansts.QueryConstants;
import com.diploma.master.demo.dao.UserDao;
import com.diploma.master.demo.mapper.UserMapper;
import com.diploma.master.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
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

    @Override
    public Optional<User> getUserByID(Integer id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(QueryConstants.GET_USER_BY_ID, userMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public User findUserByUserName(String username) {
        log.info("findUserByUserName");
        try {
            log.info("findUserByUserName {}", username);
            return jdbcTemplate.queryForObject(QueryConstants.FIND_USER_BY_EMAIL, userMapper, username);
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
    public Integer insertUser(User user) {
        log.info("insertUser User {}", user);
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(QueryConstants.INSERT_NEW_USER,
                        new String[]{"user_id"});
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getName());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getRole().getValue());
                ps.setString(6, user.getSurname());
                return ps;
            }, keyHolder);
            return Objects.requireNonNull(keyHolder.getKey()).intValue();
            //jdbcTemplate.update(QueryConstants.INSERT_NEW_USER, user.getUsername(), user.getName(), user.getEmail(), user.getPassword(), user.getRole().getValue(), user.getSurname());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
        Integer count = jdbcTemplate.queryForObject(QueryConstants.CHECK_IF_USER_NAME_EXIST, Integer.class, username);
        return count != null && count != 0;
    }

    @Override
    public Boolean checkIfEmailExists(String email) {
        Integer count = jdbcTemplate.queryForObject(QueryConstants.CHECK_IF_EMAIL_EXIST, Integer.class, email);
        return count != null && count != 0;
    }
}
