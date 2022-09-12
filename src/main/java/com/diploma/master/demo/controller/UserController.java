package com.diploma.master.demo.controller;

import com.diploma.master.demo.model.User;
import com.diploma.master.demo.service.serviceImpl.UserServiceImpl;
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

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserServiceImpl userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    //todo check @RequestBody
    @PostMapping("/create")
    public void addUser(@RequestBody User user){
        log.info("USER {}",user.toString());
       /* user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.insertUser(user);*/
    }

    @GetMapping("/all/users")
    public List<User> getAllUsers(){
        log.info("getAllUsers");
        return null;
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user){

    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/check/username/{username}}")
    public Boolean checkIfUserNameExists(@PathVariable String username){
        return true;
    }
}
