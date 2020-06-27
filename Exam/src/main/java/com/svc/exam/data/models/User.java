package com.svc.exam.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//•	Has an Id – UUID-string or Long
//        •	Has a Username (unique)
//        o	Username length must be between 3 and 20 characters (inclusive 3 and 20).
//        •	Has a Password
//        o	Password length must be between 3 and 20 characters (inclusive 3 and 20).
//        •	Has an Email
//        o	Must contains '@'.
//        o	Cannot be null.


@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String username;
    private String password;
    private String email;

    public User() {
    }

    @Column(name = "username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
