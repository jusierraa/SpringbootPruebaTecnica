package com.example.demo.cliente;

import com.demo.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "dummyClient", url = "https://dummyjson.com")
public interface DummyFeignClient {

    @PostMapping("/auth/login")
    LoginResponse login(@RequestBody LoginRequest request);

    @GetMapping("/auth/me")
    UserResponse getAuthenticatedUser(@RequestHeader("Authorization") String token);

    @GetMapping("/users")
    Object getAllUsers(); // opcionalmente puedes hacer un DTO para la lista de usuarios
}
