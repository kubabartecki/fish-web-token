package com.fishwebtoken.api.security.auth;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser> findByUsername(String username);
}
