package com.fishwebtoken.api.security.model;

public enum ApplicationUserPermission {
    USER_READ("student:read"),
    USER_WRITE("student:write"),
    STORE_MAN_READ("lecture:read"),
    STORE_MAN_WRITE("lecture:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
