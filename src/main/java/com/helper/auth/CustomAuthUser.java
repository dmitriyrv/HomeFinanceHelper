package com.helper.auth;

import java.security.Principal;

/**
 * Created by dvas on 16.11.2016.
 */
public class CustomAuthUser implements Principal {
    
    private String name;
    
    public CustomAuthUser (Integer id, String name) {
        this.name = name;
    }
    
    @Override
    public String getName () {
        return name;
    }
}
