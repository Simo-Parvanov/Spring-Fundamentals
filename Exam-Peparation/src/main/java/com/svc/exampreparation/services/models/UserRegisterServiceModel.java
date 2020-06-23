package com.svc.exampreparation.services.models;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class UserRegisterServiceModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private BigDecimal budget;

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
    @DecimalMin(value = "0",message = "Budget must be more or equal to 0!")
    @NotNull
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
