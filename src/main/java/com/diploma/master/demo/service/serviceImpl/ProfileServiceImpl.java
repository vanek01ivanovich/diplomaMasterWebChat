package com.diploma.master.demo.service.serviceImpl;

import com.diploma.master.demo.dao.ProfileDao;
import com.diploma.master.demo.model.Profile;
import com.diploma.master.demo.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileDao profileDao;

    @Autowired
    public ProfileServiceImpl(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public Profile findUserProfileById(Integer profileId) {
        return profileDao.findUserProfileById(profileId).orElseThrow(() -> new RuntimeException("Profile with id " + profileId + " was not found"));
    }

    @Override
    public Profile findUserProfileWithoutInfoById(Integer profileId) {
        return null;
    }

    @Override
    public Profile findUserProfileWithInfoByUserId(Integer userId) {
        return profileDao.findUserProfileWithInfoByUserId(userId).orElseThrow(() -> new RuntimeException("Profile with id " + userId + " was not found"));
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileDao.getAllProfiles();
    }

    @Override
    public void createProfile(Integer userId) {
        log.info("createProfile with Id {}", userId);
        profileDao.createProfile(userId);
    }

    @Override
    public void editProfile(Profile profile) {
        profileDao.editProfile(profile);
    }

    @Override
    public void activateProfile(Integer profileId) {
        profileDao.activateProfile(profileId);
    }

    @Override
    public void deactivateProfile(Integer profileId) {
        profileDao.deactivateProfile(profileId);
    }
}
