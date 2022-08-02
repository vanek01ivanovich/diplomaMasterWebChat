package com.diploma.master.demo.controller;

import com.diploma.master.demo.model.User;
import com.diploma.master.demo.model.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://localhost:8080")
public class DashboardController {

    @GetMapping("/user")
    public User userPage() {
        log.info("user");
        return new User(1,"admin","admin","admin","admin","admin", Role.ADMIN);
    }
}
