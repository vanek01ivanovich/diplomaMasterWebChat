package com.diploma.master.demo.dao.constansts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:queries/queries.properties")
public class Constants {

    @Value("${find.user.by.email.with.password}")
    public static String FIND_USER_BY_EMAIL;

    @Value("${insert.new.user}")
    public static String INSERT_NEW_USER;
}
