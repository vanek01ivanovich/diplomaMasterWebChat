package com.diploma.master.demo.controller;

import com.diploma.master.demo.model.User;
import com.diploma.master.demo.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/settings")
@RestController
public class SettingsController {
    private final EmailService emailService;

    @Autowired
    public SettingsController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/reset/password")
    public void resetPassword(@RequestBody User user){
        emailService.sendCredentialsByEmail(user);
    }
}
