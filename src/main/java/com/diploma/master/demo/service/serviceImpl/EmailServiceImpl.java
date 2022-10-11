package com.diploma.master.demo.service.serviceImpl;

import com.diploma.master.demo.constansts.MailConstants;
import com.diploma.master.demo.model.User;
import com.diploma.master.demo.service.EmailService;
import com.diploma.master.demo.util.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendCredentialsByEmail(User user) {
        log.info("sendCredentialsByEmail {}", user.toString());
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getEmail());
        String token = new TokenUtils().generatePasswordResetToken(user);

        message.setSubject(MailConstants.EMAIL_THEME);
        message.setText("To activate your account click on the following link: " +
                MailConstants.RESET_PASSWORD_LINK + token);

        mailSender.send(message);
    }

}
