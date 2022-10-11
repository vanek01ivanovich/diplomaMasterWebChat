package com.diploma.master.demo.dao;

import com.diploma.master.demo.model.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileDao {
    Optional<Profile> findUserProfileById(Integer profileId);

    Optional<Profile> findUserProfileWithInfoByUserId(Integer userId);

    Optional<Profile> findUserProfileWithoutInfoByUserId(Integer userId);

    void createProfile(Integer userId);

    List<Profile> getAllProfiles();

    void editProfile(Profile profile);

    void activateProfile(Integer profileId);

    void deactivateProfile(Integer profileId);
}
