package com.fishwebtoken.api.security.auth;

import com.fishwebtoken.api.security.model.ApplicationUserRole;
import com.fishwebtoken.api.user.User;
import com.fishwebtoken.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("postgres")
public class PostgresApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public PostgresApplicationUserDaoService(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public Optional<ApplicationUser> findByUsername(String username) {
        Optional<User> userOptional = userService.getUserByUsername(username);
        if (userOptional.isEmpty()) {
            return Optional.empty();
        }

        User user = userOptional.get();
        ApplicationUserRole role;
        try {
            role = ApplicationUserRole.valueOf(user.getRole());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role: " + user.getRole(), e);
        }

        return Optional.of(new ApplicationUser(
                user.getUsername(),
                passwordEncoder.encode(user.getPassword()),
                role.getGrantedAuthorities(),
                true,
                true,
                true,
                true
        ));
    }
}
