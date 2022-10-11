package com.diploma.master.demo.model.entity;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    public final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
