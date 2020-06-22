package com.svc.exampreparation.Date;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String username;
    private String password;
    private String email;
    private Integer budget;
    private Set<Item> itemSet;

    public User() {
    }

    @Column(name = "username", unique = true)
    @Length(min = 2)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    @Length(min = 2)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", unique = true)
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "ebudget")
    @Positive
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @OneToMany
    public Set<Item> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<Item> itemSet) {
        this.itemSet = itemSet;
    }
}
