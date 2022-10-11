package com.diploma.master.demo.controller;

import com.diploma.master.demo.model.Profile;
import com.diploma.master.demo.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/profile")
@RestController
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/info/{userId}")
    public Profile getProfileWithInfoByUserId(@PathVariable Integer userId) {
        log.info("getMyProfileByUserId by userId {}", userId);
        return profileService.findUserProfileWithInfoByUserId(userId);
    }

    @GetMapping("/without/info/{userId}")
    public Profile getProfileWithoutInfoByUserId(@PathVariable Integer userId) {
        log.info("getMyProfileByUserId by userId {}", userId);
        return profileService.findUserProfileWithoutInfoById(userId);
    }

    @PostMapping("/create")
    public void createProfile(@RequestBody Profile profile) {
        log.info("create Profile {}", profile);
    }

    //todo get image file
    @GetMapping("/get/{profileID}")
    public Profile findUserProfileById(@PathVariable Integer profileID) {
        log.info("findUserProfileById with profileId {}", profileID);
        //todo find profile using join
        return profileService.findUserProfileById(profileID);
    }

    @PostMapping("/edit")
    public void editProfile(@RequestBody Profile profile) {
        profileService.editProfile(profile);
    }

    @PostMapping("/activate/{profileID}")
    public void activateProfile(@PathVariable Integer profileID) {
        profileService.activateProfile(profileID);
    }

    @PostMapping("/deactivate/{profileID}")
    public void deactivateProfile(@PathVariable Integer profileID) {
        profileService.deactivateProfile(profileID);
    }

    @GetMapping("/get/all")
    public List<Profile> getAllProfiles() {
        log.info("getAllProfiles Controller");
        return profileService.getAllProfiles();
    }
}
