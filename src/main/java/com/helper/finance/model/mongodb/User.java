package com.helper.finance.model.mongodb;

import org.springframework.data.annotation.Id;

/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */
public class User {

    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean active;

    public User() {
    }

    public User(String id, String email, String firstName, String lastName, String password, boolean active) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
