package com.diploma.master.demo.mapper;

import com.diploma.master.demo.model.Profile;

import com.diploma.master.demo.model.entity.Gender;
import com.diploma.master.demo.model.entity.Language;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Component
public class ProfileWithoutInfoMapper implements RowMapper<Profile> {

    @Override
    public Profile mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        log.info("resultSet {}", resultSet);
        Integer profileId = resultSet.getInt("id");
        Integer userLevel = resultSet.getInt("user_level");
        Integer userId = resultSet.getInt("user_id");
        Integer language = resultSet.getInt("language_id");
        Integer phoneNumber = resultSet.getInt("phone_number");
        Gender gender = Gender.valueOf(resultSet.getString("gender"));
        String aboutMe = resultSet.getString("about_me");
        //todo get image file
        //Object userPhoto = resultSet.getObject("user_photo");
        Boolean isActive = Boolean.valueOf(resultSet.getString("active"));
        //log.info("userPhoto {}", userPhoto);
        Profile profile = Profile.builder()
                .id(profileId)
                .userLevel(userLevel)
                .userId(userId)
                //.language(language)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .aboutMe(aboutMe)
                .active(isActive)
                .build();
        log.info("Profile {}", profile.toString());
        return null;
    }
}
