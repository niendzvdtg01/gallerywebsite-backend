package com.gallery.backend.dtorequests;

public class LoginRequest {
    private String username;
    private String userpassword;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return this.userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public LoginRequest(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }
}
