package com.farahhannah.fstgrabcarservice.Model;

import com.google.firebase.database.ValueEventListener;

/**
 * Created by owner1 on 11/17/2017.
 */

public class Driver {

    private String username;
    private String password;
    private String email;

    public Driver(){

    }

    public Driver(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addListenerForSingleValueEvent(ValueEventListener valueEventListener) {
    }

    public void child(String driver) {
    }

    public void setValue() {
    }
}
