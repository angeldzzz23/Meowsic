package com.meowsic.meows.controller;

import com.meowsic.meows.payload.JWTAuthResponse;
import com.meowsic.meows.payload.LoginDto;
import com.meowsic.meows.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // build login rest api
    // Buid Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return  ResponseEntity.ok(jwtAuthResponse);

    }

    // build regiuster rest api
//    @PostMapping(value = {"/register", "/signup"})
//    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
//        String response = authService.register(registerDto);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }


}
