package com.fishwebtoken.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User addUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return null;
        }
        return userRepository.save(user);
    }
}
