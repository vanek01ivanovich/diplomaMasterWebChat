package com.diploma.master.demo.controller;

import com.diploma.master.demo.config.JwtTokenUtil;
import com.diploma.master.demo.model.dto.JwtRequest;
import com.diploma.master.demo.model.dto.JwtResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> userAuthentication(@RequestBody JwtRequest jwtRequest) {
        log.info("JwtRequest {}", jwtRequest);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                jwtRequest.getEmail(),
                jwtRequest.getPassword()
        ));
        log.info("Authentication {}", authentication);
        String jwtToken = jwtTokenUtil.generateJwtToken(authentication);
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwtToken, principal.getUsername(), principal.getAuthorities()));
    }

}
