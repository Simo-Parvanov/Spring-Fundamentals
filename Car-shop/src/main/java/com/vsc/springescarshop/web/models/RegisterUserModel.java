package com.vsc.springescarshop.web.models;

import javax.validation.constraints.NotEmpty;

public class RegisterUserModel {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String role;

    public RegisterUserModel() {
    }

    @NotEmpty(message = "Please enter Username!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty(message = "Please enter First Name!")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty(message = "Please enter Last Name!")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotEmpty@NotEmpty(message = "Please enter Password!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotEmpty@NotEmpty(message = "Please repeat Password! ")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String transmission) {
        this.role = transmission;
    }

}
