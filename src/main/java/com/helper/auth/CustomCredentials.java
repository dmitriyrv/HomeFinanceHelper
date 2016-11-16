package com.helper.auth;

import java.util.UUID;

/**
 * Created by dvas on 16.11.2016.
 */
public class CustomCredentials {
    private UUID token;
    private Integer userId;
    
    public UUID getToken () {
        return token;
    }
    
    public void setToken (UUID token) {
        this.token = token;
    }
    
    public Integer getUserId () {
        return userId;
    }
    
    public void setUserId (Integer userId) {
        this.userId = userId;
    }
}
