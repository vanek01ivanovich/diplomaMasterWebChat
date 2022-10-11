package com.diploma.master.demo.model.entity;

public enum Language {
    ENG("ENG"),
    UKR("UKR"),
    RUS("RUS");

    public final String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
