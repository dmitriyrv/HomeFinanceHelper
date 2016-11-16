package com.helper.auth;

import com.helper.core.Token;
import com.helper.core.User;
import com.helper.db.TokenDao;
import com.helper.db.UserDao;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.hibernate.UnitOfWork;

import java.util.Optional;

/**
 * Created by dvas on 16.11.2016.
 */
public class CustomAuthenticator implements Authenticator<CustomCredentials, CustomAuthUser>{
    
    private TokenDao tokenDao; //TODO: change to service layer
    private UserDao userDao;
    
    public CustomAuthenticator (TokenDao tokenDao, UserDao userDao) {
        this.tokenDao = tokenDao;
        this.userDao = userDao;
    }
    
    @Override
    @UnitOfWork
    public Optional<CustomAuthUser> authenticate (CustomCredentials customCredentials) throws AuthenticationException {
        
        CustomAuthUser authenticatedUser = null;
        
        Optional<User> user = userDao.getUser(customCredentials.getUserId());
    
        if (user.isPresent()) {
            Optional<Token> tokenOptional = tokenDao.findTokenForUser(user.get());
    
            if (tokenOptional.isPresent()) {
                Token token = tokenOptional.get();
    
                if (token.getId().equals(customCredentials.getToken())) {
                    authenticatedUser = new CustomAuthUser(token.getUser().getUserId(), token.getUser().getEmail());
                }
            }
        }
        
        return Optional.ofNullable(authenticatedUser);
    }
}
