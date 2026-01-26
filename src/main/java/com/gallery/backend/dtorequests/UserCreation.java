package com.gallery.backend.dtorequests;

public class UserCreation {
    private String username;
    private String email;
    private String userpassword;
    private String firstname;
    private String lastname;

    public UserCreation(String username, String email, String userpassword, String firstname, String lastname) {
        this.username = username;
        this.email = email;
        this.userpassword = userpassword;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserpassword() {
        return this.userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
