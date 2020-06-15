package com.vsc.springescarshop.services.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class LoginServiceModel {
    private String id;
    private String username;
    private String password;
    private String roles;

    public LoginServiceModel() {
    }

    @NotNull
    @Length(min = 3, max = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Length(min = 4, max = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
