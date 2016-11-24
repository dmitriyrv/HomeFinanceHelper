package com.helper.service;

import com.helper.core.Token;
import com.helper.core.User;
import com.helper.db.TokenDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.io.Reader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by dvas on 21.11.2016.
 */
public class TokenServiceTest {
    
    /*TokenService tokenService;
    @Mock
    SqlSessionFactory mockSessionFactory;
    @Mock
    SqlSession mockSqlSession;
    @Mock
    TokenDao mockTokenDao;*/
    
    
    
    @Before
    public void setUp () throws Exception {
        
    }
    
    @After
    public void tearDown () throws Exception {
        
    }
    
    @Test
    public void findAccessTokenById () throws Exception {
        //TODO: this is NOT mocked
        TokenService tokenService = new TokenService(getSqlSessionFactory());
        Token stubToken = new Token(UUID.fromString("37253888-1122-4b02-beb0-9eb1be76457d"), 1, LocalDateTime.parse("2016-11-22T11:55:50", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        Token resultToken = tokenService.findAccessTokenById(UUID.fromString("37253888-1122-4b02-beb0-9eb1be76457d")).get();
        
        assertEquals(resultToken, stubToken);
    }
    
    @Test
    public void generateNewAccessToken () throws Exception {
        /*when(mockSessionFactory.openSession()).thenReturn(mockSqlSession);
        when(mockSqlSession.getMapper(TokenDao.class)).thenReturn(mockTokenDao);
        when(mockTokenDao.generateNewAccessToken()).thenReturn(stubUser);*/
        //TODO: this is NOT mocked
        TokenService tokenService = new TokenService(getSqlSessionFactory());
        
        tokenService.generateNewAccessToken(new User(1, "admin@mock.com", "Stubbed", "User"), LocalDateTime.now());
        
        
    }
    
    @Test
    public void setLastAccessTime () throws Exception {
        TokenService tokenService = new TokenService(getSqlSessionFactory());
        UUID stubUuid = UUID.fromString("37253888-1122-4b02-beb0-9eb1be76457d");
        
        LocalDateTime now = LocalDateTime.now();
        
        Token stubToken = new Token(stubUuid, 1, now);
        
        tokenService.setLastAccessTime(stubUuid, now);
        
        Token resultToken = tokenService.findAccessTokenById(stubUuid).get();
        
        assertEquals(stubToken, resultToken);
        
    }
    
    private SqlSessionFactory getSqlSessionFactory () {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("MyBatisConfig.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return new SqlSessionFactoryBuilder().build(reader);
    }
    
}