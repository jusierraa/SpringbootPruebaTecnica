package com.example.demo.service;

import com.demo.client.DummyFeignClient;
import com.demo.dto.*;
import com.demo.model.LoginLog;
import com.demo.repository.LoginLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final DummyFeignClient dummyClient;
    private final LoginLogRepository repository;

    public UserResponse login(LoginRequest request) {
        LoginResponse response = dummyClient.login(request);

        LoginLog log = new LoginLog();
        log.setUsername(response.getUsername());
        log.setLoginTime(LocalDateTime.now());
        log.setAccessToken(response.getToken());
        log.setRefreshToken(response.getRefreshToken());

        repository.save(log);

        return dummyClient.getAuthenticatedUser("Bearer " + response.getToken());
    }
}