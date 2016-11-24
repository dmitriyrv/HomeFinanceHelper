package com.helper.auth;

import com.helper.core.Token;
import com.helper.core.User;
import com.helper.service.TokenService;
import com.helper.service.UserService;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by dvas on 18.11.2016.
 */
public class HelperOAuthAuthenticator implements Authenticator<String, User> {
    public static final int ACCESS_TOKEN_EXPIRE_TIME_MIN = 30;
    private TokenService tokenService;
    private UserService userService;
    
    public HelperOAuthAuthenticator (TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }
    
    @Override
    public Optional<User> authenticate (String accessTokenId) throws AuthenticationException {
        
        UUID accessTokenUuid;
        
        try {
            accessTokenUuid = UUID.fromString(accessTokenId);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        
        Optional<Token> accessToken = tokenService.findAccessTokenById(accessTokenUuid);
        if (!accessToken.isPresent()) {
            return Optional.empty();
        }
        
        Duration duration = Duration.between(accessToken.get().getLastAccess(), LocalDateTime.now());
        if (duration.getSeconds() / 60 > ACCESS_TOKEN_EXPIRE_TIME_MIN) {
            return Optional.empty();
        }
        
        tokenService.setLastAccessTime(accessTokenUuid, LocalDateTime.now());
        
        return Optional.of(userService.getUser(accessToken.get().getUserId()));
    }
}
