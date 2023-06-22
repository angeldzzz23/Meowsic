package com.meowsic.meows.service;

import com.meowsic.meows.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
