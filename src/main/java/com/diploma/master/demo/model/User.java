package com.diploma.master.demo.model;

import com.diploma.master.demo.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String surname;
    private String email;
    private String username;
    private Role role;
}
