package com.helper.auth;

import io.dropwizard.auth.AuthFilter;
import io.dropwizard.auth.AuthenticationException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by dvas on 16.11.2016.
 */
public class CustomAuthFilter extends AuthFilter<CustomCredentials, CustomAuthUser> {
    
    private CustomAuthenticator authenticator;
    
    @Override
    public void filter (ContainerRequestContext containerRequestContext) throws IOException {
    
        Optional<CustomAuthUser> authenticatedUser;
        
        try{
            CustomCredentials credentials = getCredentials(containerRequestContext);
            authenticatedUser = authenticator.authenticate(credentials);
        } catch (AuthenticationException e){
            throw new WebApplicationException("Unable to validate credentials", Response.Status.UNAUTHORIZED);
        }
    
        if (!authenticatedUser.isPresent()) {
            throw new WebApplicationException("Credentials not valid", Response.Status.UNAUTHORIZED);
        }
        
    }
    
    private CustomCredentials getCredentials (ContainerRequestContext requestContext) {
        
        CustomCredentials credentials = new CustomCredentials();
        
        try{
            String rawToken = requestContext
                    .getCookies()
                    .get("auth_token")
                    .getValue();
            
            String rawUserId = requestContext
                    .getCookies()
                    .get("auth_user")
                    .getValue();
            
            credentials.setToken(UUID.fromString(rawToken));
            credentials.setUserId(Integer.valueOf(rawUserId));
        } catch (Exception e){
            throw new WebApplicationException("Unable to parse credentials", Response.Status.UNAUTHORIZED);
        }
        
        return credentials;
    }
}
