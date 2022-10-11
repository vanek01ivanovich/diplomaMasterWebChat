package com.diploma.master.demo.controller;

import com.diploma.master.demo.config.JwtTokenUtil;
import com.diploma.master.demo.model.dto.AuthRequest;
import com.diploma.master.demo.model.dto.JwtResponse;
import com.diploma.master.demo.service.serviceImpl.UserPrincipal;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> userAuthentication(@RequestBody AuthRequest authRequest) {
        try {
            log.info("JwtRequest {}", authRequest);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(),
                    authRequest.getPassword()
            ));
            log.info("Authentication {}", authentication.getAuthorities());
            String jwtToken = jwtTokenUtil.generateJwtToken(authentication);
            UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
            log.info("principal {}", principal);
            log.info("principal get userId {}", principal.getUserId());
            return ResponseEntity.ok(new JwtResponse(principal.getUserId(), jwtToken, principal.getUsername(), principal.getAuthorities()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
