package com.svc.exampreparation.services.models;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserLoginServiceModel {
    private String username;
    private String password;

    public UserLoginServiceModel() {
    }

    @Length(min = 2, message = "Username must be more than two characters!")
    @NotNull(message = "Username type is required.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 2, message = "Password must be more than two characters!")
    @NotNull(message = "Password type is required.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
