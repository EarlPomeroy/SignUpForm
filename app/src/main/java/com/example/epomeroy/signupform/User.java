package com.example.epomeroy.signupform;

import java.io.Serializable;

/**
 * Created by epomeroy on 9/12/15.
 */
public class User implements Serializable {
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
