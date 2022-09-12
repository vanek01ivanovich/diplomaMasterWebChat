package com.diploma.master.demo.model.entity;

public enum Role {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    public final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
