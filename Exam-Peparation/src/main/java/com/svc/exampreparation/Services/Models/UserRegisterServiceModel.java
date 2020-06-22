package com.svc.exampreparation.Services.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class UserRegisterServiceModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private Integer budget;

    public UserRegisterServiceModel() {
    }
    @Min(value = 2, message = "Username must by more then tow characters!")
    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Min(value = 2, message = "Password must by more then tow characters!")
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotNull
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Positive(message = "Budget must be more or equal to 0!")
    @NotNull
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }
}
