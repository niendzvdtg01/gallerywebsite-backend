package com.gallery.backend.dtorequests;

public class LoginRepos {
    private String token;

    public LoginRepos(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
