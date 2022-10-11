package com.diploma.master.demo.model;

import com.diploma.master.demo.model.entity.Gender;
import com.diploma.master.demo.model.entity.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {
    //todo create ProfileDTO
    private Integer id;
    private Integer userId;
    private String username;
    private Language language;
    private Integer userLevel;
    private Integer phoneNumber;
    private Gender gender;
    private String aboutMe;
    private Boolean active;
}
