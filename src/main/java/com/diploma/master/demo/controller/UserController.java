package com.diploma.master.demo.controller;

import com.diploma.master.demo.model.User;
import com.diploma.master.demo.service.EmailService;
import com.diploma.master.demo.service.ProfileService;
import com.diploma.master.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final ProfileService profileService;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder, EmailService emailService, ProfileService profileService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.profileService = profileService;
    }

    //todo add new profile while creating user
    //todo check @RequestBody
    @PostMapping("/create")
    public void addUser(@RequestBody User user) {
        log.info("addUser {}", user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.insertUser(user);
        //emailService.sendCredentialsByEmail(user);
    }

    @PostMapping("/create/with/profile")
    public void addUserWithProfile(@RequestBody User user) {
        log.info("addUserWithProfile {}", user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Integer id = userService.insertUser(user);
        //emailService.sendCredentialsByEmail(user);
        log.info("addUserWithProfile user id {}", id);
        profileService.createProfile(id);
    }

    @GetMapping("/all/users")
    public List<User> getAllUsers() {
        log.info("getAllUsers");
        return null;
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {

    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/check/username/{username}")
    public Boolean checkIfUserNameExists(@PathVariable String username) {
        log.info("checkIfUserNameExists {}", username);
        return userService.checkIfUserNameExists(username);
    }

    @GetMapping("/check/email/{email}")
    public Boolean checkIfEmailExists(@PathVariable String email) {
        log.info("checkIfEmailExists {}", email);
        return userService.checkIfEmailExists(email);
    }


}
