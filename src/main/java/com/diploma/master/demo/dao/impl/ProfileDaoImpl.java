package com.diploma.master.demo.dao.impl;

import com.diploma.master.demo.constansts.QueryConstants;
import com.diploma.master.demo.dao.ProfileDao;
import com.diploma.master.demo.mapper.ProfileWithInfoMapper;
import com.diploma.master.demo.mapper.ProfileWithoutInfoMapper;
import com.diploma.master.demo.model.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class ProfileDaoImpl implements ProfileDao {

    private final JdbcTemplate jdbcTemplate;
    private final ProfileWithInfoMapper profileWithInfoMapper;
    private final ProfileWithoutInfoMapper profileWithoutInfoMapper;

    @Autowired
    public ProfileDaoImpl(JdbcTemplate jdbcTemplate, ProfileWithInfoMapper profileWithInfoMapper, ProfileWithoutInfoMapper profileWithoutInfoMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.profileWithInfoMapper = profileWithInfoMapper;
        this.profileWithoutInfoMapper = profileWithoutInfoMapper;
    }

    @Override
    public Optional<Profile> findUserProfileById(Integer profileId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(QueryConstants.GET_PROFILE_WITHOUT_INFO_BY_USER_ID, profileWithInfoMapper, profileId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Profile> findUserProfileWithInfoByUserId(Integer userId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(QueryConstants.GET_PROFILE_WITH_INFO_BY_USER_ID, profileWithInfoMapper, userId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Profile> findUserProfileWithoutInfoByUserId(Integer userId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(QueryConstants.GET_PROFILE_WITHOUT_INFO_BY_USER_ID, profileWithoutInfoMapper, userId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void createProfile(Integer userId) {
        try {
            jdbcTemplate.update(QueryConstants.CREATE_PROFILE, 1, userId, 1, null, null, null, null, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Profile> getAllProfiles() {
        log.info("getAllProfiles");
        try {
            return jdbcTemplate.query(QueryConstants.GET_ALL_PROFILES, profileWithInfoMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void editProfile(Profile profile) {
        try {
            //todo update profile with information
            jdbcTemplate.update(QueryConstants.CREATE_PROFILE, profile.getUserLevel(), profile.getUserId(), null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void activateProfile(Integer profileId) {
        try {
            jdbcTemplate.update(QueryConstants.ACTIVATE_PROFILE, profileId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deactivateProfile(Integer profileId) {
        try {
            jdbcTemplate.update(QueryConstants.DEACTIVATE_PROFILE, profileId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
