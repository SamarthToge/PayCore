package com.authentication.authentication.DTOs;

import org.springframework.http.HttpStatus;

public record ErrorResponse(
        String message,
        HttpStatus status,
        int statuscpde
) {

}
