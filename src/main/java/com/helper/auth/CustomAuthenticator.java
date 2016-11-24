package com.helper.auth;

import com.helper.core.Token;
import com.helper.core.User;
import com.helper.db.TokenDao;
import com.helper.db.UserDao;
import com.helper.service.UserService;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.hibernate.UnitOfWork;

import java.util.Optional;

/**
 * Created by dvas on 16.11.2016.
 */
public class CustomAuthenticator implements Authenticator<CustomCredentials, CustomAuthUser>{
    
    private TokenDao tokenDao; //TODO: change to service layer
    private UserService userService;
    
    public CustomAuthenticator (TokenDao tokenDao, UserService userService) {
        this.tokenDao = tokenDao;
        this.userService = userService;
    }
    
    @Override
    @UnitOfWork
    public Optional<CustomAuthUser> authenticate (CustomCredentials customCredentials) throws AuthenticationException {
        
        CustomAuthUser authenticatedUser = null;
        
        User user = userService.getUser(customCredentials.getUserId());
    
        /*if (user != null) {
            Optional<Token> tokenOptional = tokenDao.findTokenForUser(user);
    
            if (tokenOptional.isPresent()) {
                Token token = tokenOptional.get();
    
                if (token.getId().equals(customCredentials.getToken())) {
                    authenticatedUser = new CustomAuthUser(token.getUser().getUserId(), token.getUser().getEmail());
                }
            }
        }
        
        return Optional.ofNullable(authenticatedUser);*/
        return null;
    }
}
