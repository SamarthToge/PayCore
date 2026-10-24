package com.authentication.authentication.DTOs;

public record TokenResponse(
        String accessToken,
        String refreshToken,
        long expireIn,
        String tokenType,
        UserDTO user
) {
    public static TokenResponse of(String accessToken, String refreshToken, long expireIn, UserDTO user){
        return new TokenResponse(accessToken,refreshToken,expireIn,"Bearer",user);
    }
}
