package com.diploma.master.demo.service;

import com.diploma.master.demo.model.Profile;

import java.util.List;

public interface ProfileService {

    Profile findUserProfileById(Integer profileId);

    Profile findUserProfileWithoutInfoById(Integer profileId);

    Profile findUserProfileWithInfoByUserId(Integer userId);

    List<Profile> getAllProfiles();

    void createProfile(Integer userId);

    void editProfile(Profile profile);

    void activateProfile(Integer profileId);

    void deactivateProfile(Integer profileId);


}
