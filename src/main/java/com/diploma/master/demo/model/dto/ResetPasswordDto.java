package com.diploma.master.demo.model.dto;

import lombok.Data;

@Data
public class ResetPasswordDto {
    private String token;
    private String password;
}
