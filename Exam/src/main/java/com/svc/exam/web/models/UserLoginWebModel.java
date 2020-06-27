package com.svc.exam.web.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserLoginWebModel {
    private String username;
    private String password;

    public UserLoginWebModel() {
    }

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    @NotNull(message = "Username type is required.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    @NotNull(message = "Username type is required.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
