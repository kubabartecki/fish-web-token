package com.fishwebtoken.api.security.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.fishwebtoken.api.security.model.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(new HashSet<>(Arrays.asList(USER_READ, USER_WRITE))),
    STORE_MAN(new HashSet<>(Arrays.asList(USER_READ, USER_WRITE, STORE_MAN_READ, STORE_MAN_WRITE))),
    ADMIN(new HashSet<>(Arrays.asList(USER_READ, USER_WRITE, STORE_MAN_READ, STORE_MAN_WRITE, ADMIN_READ, ADMIN_WRITE)));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> grantedAuthorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + name()));
        return grantedAuthorities;
    }
}
