package com.helper.service;

import com.helper.core.Token;
import com.helper.core.User;
import com.helper.db.TokenDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by dvas on 18.11.2016.
 */
public class TokenService {
    private SqlSessionFactory sessionFactory;
    
    public TokenService (SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    public Optional<Token> findAccessTokenById (UUID accessToken) {
        
        if (accessToken == null) {
            throw new IllegalArgumentException("Token UUID should not be null.");
        }
        
        SqlSession sqlSession = sessionFactory.openSession();
        
        
        try {
            TokenDao tokenDao = sqlSession.getMapper(TokenDao.class);
            return Optional.of(tokenDao.findAccessTokenById(accessToken.toString()));
        } finally {
            sqlSession.close();
        }
        
    }
    
    public Token generateNewAccessToken (User user, LocalDateTime dateTime) {
        
        if (user == null) {
            throw new IllegalArgumentException("User should not be null.");
        }
        
        if (dateTime == null) {
            dateTime = LocalDateTime.now();
        }
        
        Token newToken = new Token(UUID.randomUUID(), user.getUserId(), dateTime);
        
        SqlSession sqlSession = sessionFactory.openSession();
        
        try {
            TokenDao tokenDao = sqlSession.getMapper(TokenDao.class);
            tokenDao.generateNewAccessToken(newToken);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        
        return newToken;
        
    }
    
    public void setLastAccessTime (UUID accessTokenUUID, LocalDateTime dateTime) {
        
        Optional<Token> foundToken = this.findAccessTokenById(accessTokenUUID);
        
        if (!foundToken.isPresent()) {
            throw new RuntimeException(String.format("Token with UUID %s not found", accessTokenUUID.toString()));
        }
    
        SqlSession sqlSession = sessionFactory.openSession();
    
        try {
            TokenDao tokenDao = sqlSession.getMapper(TokenDao.class);
            tokenDao.setLastAccessTime(accessTokenUUID, dateTime);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        
    }
}
