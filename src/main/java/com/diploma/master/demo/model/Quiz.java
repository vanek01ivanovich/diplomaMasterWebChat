package com.diploma.master.demo.model;

import com.diploma.master.demo.model.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {
    private Integer id;
    private String name;
    private String description;
    private Integer categoryId;
    private Status status;
}
