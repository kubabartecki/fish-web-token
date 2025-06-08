package com.fishwebtoken.api.security.auth;

import com.fishwebtoken.api.security.model.ApplicationUserRole;
import com.fishwebtoken.api.security.model.UsernameAndPasswordAuthenticationRequest;
import com.fishwebtoken.api.user.User;
import com.fishwebtoken.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UsernameAndPasswordAuthenticationRequest requestUser) {
        Optional<User> user = userService.addBasicUser(
                requestUser.getUsername(),
                requestUser.getPassword(),
                ApplicationUserRole.USER.name()
        );
        if (user.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("User registration failed. Maybe username already exists.");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully");
    }
}
