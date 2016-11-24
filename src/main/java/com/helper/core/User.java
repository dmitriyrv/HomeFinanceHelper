package com.helper.core;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * Created by dvas on 16.11.2016.
 */
public class User implements Principal {
    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    
    public User () {
    }
    
    public User (Integer userId, String email, String firstName, String lastName) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Integer getUserId () {
        return userId;
    }
    
    public void setUserId (Integer userId) {
        this.userId = userId;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getFirstName () {
        return firstName;
    }
    
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName () {
        return lastName;
    }
    
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    
    public String getPassword () {
        return password;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }
    
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        User user = (User) o;
        
        if (!userId.equals(user.userId)) return false;
        if (!email.equals(user.email)) return false;
        if (!firstName.equals(user.firstName)) return false;
        return lastName.equals(user.lastName);
    
    }
    
    @Override
    public int hashCode () {
        int result = userId.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
    
    @Override
    public String getName () {
        return email;
    }
    
    @Override
    public boolean implies (Subject subject) {
        return false;
    }
    
    
}
