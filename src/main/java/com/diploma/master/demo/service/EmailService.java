package com.diploma.master.demo.service;

import com.diploma.master.demo.model.User;

public interface EmailService {
    void sendCredentialsByEmail(User user);
}
