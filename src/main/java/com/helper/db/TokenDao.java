package com.helper.db;

import com.helper.core.Token;
import com.helper.core.User;
import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by dvas on 16.11.2016.
 */
public interface TokenDao {
    Token findAccessTokenById (String accessToken);
    
    void generateNewAccessToken (Token newToken);
    
    void setLastAccessTime (UUID accessToken, LocalDateTime dateTime);
}
