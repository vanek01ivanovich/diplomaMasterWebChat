package com.diploma.master.demo.constansts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:constants/constants.properties")
public class MailConstants {
    public static final String EMAIL = "ivan";
    public static final String EMAIL_PASS = "";
    public static final String EMAIL_THEME = "Activate your account for testing app";
    public static String RESET_PASSWORD_LINK;

    @Value("${user.reset.password.page}")
    public void setResetPasswordLink(String resetPasswordLink) {
        MailConstants.RESET_PASSWORD_LINK = resetPasswordLink;
    }

}
