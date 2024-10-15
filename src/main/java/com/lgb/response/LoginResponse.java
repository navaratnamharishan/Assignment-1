package com.lgb.response;

public class LoginResponse {
    private String message;
    private boolean success;
    private String role;

    public LoginResponse(String message, boolean success, String role) {
        this.message = message;
        this.success = success;
        this.role = role;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getRole() {
        return role;
    }
}
