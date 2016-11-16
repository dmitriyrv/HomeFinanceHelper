package com.helper.core;

import java.util.UUID;

/**
 * Created by dvas on 16.11.2016.
 */
public class Token {
    
    private UUID id;
    private User user;
    
    public Token () {
    }
    
    public Token (UUID id, User user) {
        this.id = id;
        this.user = user;
    }
    
    public UUID getId () {
        return id;
    }
    
    public void setId (UUID id) {
        this.id = id;
    }
    
    public User getUser () {
        return user;
    }
    
    public void setUser (User user) {
        this.user = user;
    }
    
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Token token = (Token) o;
        
        if (!id.equals(token.id)) return false;
        return user.equals(token.user);
    
    }
    
    @Override
    public int hashCode () {
        int result = id.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
