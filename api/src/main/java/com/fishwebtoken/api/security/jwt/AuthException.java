package com.fishwebtoken.api.security.jwt;

public class AuthException extends RuntimeException {
    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
