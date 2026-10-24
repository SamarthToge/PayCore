package com.authentication.authentication.DTOs;

public record LoginRequest(
        String email,
        String password
) {

}