package com.diploma.master.demo.mapper;

import com.diploma.master.demo.model.User;
import com.diploma.master.demo.model.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@Component
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer userId = resultSet.getInt("user_id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        Role role = Role.valueOf(resultSet.getString("role"));
        String surname = resultSet.getString("surname");
        String username = resultSet.getString("username");
        User user = User.builder()
                .id(userId)
                .name(name)
                .email(email)
                .password(password)
                .role(role)
                .surname(surname)
                .username(username)
                .build();
        log.info("UserMapper user {}", user);
        return user;
    }
}
