package com.diploma.master.demo.constansts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:queries/queries.properties")
public class QueryConstants {

    public static String FIND_USER_BY_EMAIL;
    public static String INSERT_NEW_USER;
    public static String GET_ALL_USERS;
    public static String GET_USER_BY_ID;
    public static String CHECK_IF_USER_NAME_EXIST;
    public static String CHECK_IF_EMAIL_EXIST;
    public static String GET_PROFILE_WITHOUT_INFO_BY_USER_ID;
    public static String CREATE_PROFILE;
    public static String ACTIVATE_PROFILE;
    public static String DEACTIVATE_PROFILE;
    public static String GET_PROFILE_WITH_INFO_BY_USER_ID;
    public static String GET_ALL_PROFILES;

    @Value("${get.all.users}")
    public void setGetAllUsers(String getAllUsers) {
        QueryConstants.GET_ALL_USERS = getAllUsers;
    }

    @Value("${get.all.profiles}")
    public void setGetAllProfiles(String getAllProfiles) {
        QueryConstants.GET_ALL_PROFILES = getAllProfiles;
    }

    @Value("${get.user.by.id}")
    public void setGetUserById(String getUserById) {
        QueryConstants.GET_USER_BY_ID = getUserById;
    }

    @Value("${check.if.user.name.exists}")
    public void setCheckIfUserNameExist(String checkIfUserNameExist) {
        QueryConstants.CHECK_IF_USER_NAME_EXIST = checkIfUserNameExist;
    }

    @Value("${check.if.email.exists}")
    public void setCheckIfEmailExist(String checkIfEmailExist) {
        QueryConstants.CHECK_IF_EMAIL_EXIST = checkIfEmailExist;
    }

    @Value("${find.user.by.email.with.password}")
    public void setFIND_USER_BY_EMAIL(String FIND_USER_BY_EMAIL) {
        QueryConstants.FIND_USER_BY_EMAIL = FIND_USER_BY_EMAIL;
    }

    @Value("${insert.new.user}")
    public void setInsertNewUser(String insertNewUser) {
        QueryConstants.INSERT_NEW_USER = insertNewUser;
    }

    @Value("${get.profile.without.info.by.id}")
    public void setGetProfileById(String getProfileById) {
        QueryConstants.GET_PROFILE_WITHOUT_INFO_BY_USER_ID = getProfileById;
    }

    @Value("${get.profile.with.info.by.user.id}")
    public void setGetProfileByUserId(String getProfileByUserId) {
        QueryConstants.GET_PROFILE_WITH_INFO_BY_USER_ID = getProfileByUserId;
    }

    @Value("${insert.new.profiler}")
    public void setCreateProfile(String createProfile) {
        QueryConstants.CREATE_PROFILE = createProfile;
    }

    @Value("${activate.user.profile}")
    public static void setActivateProfile(String activateProfile) {
        QueryConstants.ACTIVATE_PROFILE = activateProfile;
    }

    @Value("${deactivate.user.profile}")
    public static void setDeactivateProfile(String deactivateProfile) {
        QueryConstants.DEACTIVATE_PROFILE = deactivateProfile;
    }


}
