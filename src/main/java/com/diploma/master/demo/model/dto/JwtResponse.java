package com.diploma.master.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
}
