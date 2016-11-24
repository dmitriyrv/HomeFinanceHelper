package com.helper.core;

import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by dvas on 16.11.2016.
 */
public class Token {
    
    private UUID token;
    private Integer userId;
    private LocalDateTime lastAccess;
    
    public Token () {
    }
    
    public Token (UUID token, Integer userId, LocalDateTime lastAccess) {
        this.token = token;
        this.userId = userId;
        this.lastAccess = lastAccess;
    }
    
    public Token (String tokenUuid, Integer userId, LocalDateTime lastAccess){
        this(UUID.fromString(tokenUuid), userId, lastAccess);
    }
    
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
    
    public LocalDateTime getLastAccess () {
        return lastAccess;
    }
    
    public void setLastAccess (LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }
    
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Token token1 = (Token) o;
        
        if (token != null ? !token.equals(token1.token) : token1.token != null) return false;
        if (userId != null ? !userId.equals(token1.userId) : token1.userId != null) return false;
        return lastAccess != null ? lastAccess.equals(token1.lastAccess) : token1.lastAccess == null;
    
    }
    
    @Override
    public int hashCode () {
        int result = token != null ? token.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (lastAccess != null ? lastAccess.hashCode() : 0);
        return result;
    }
}
