package com.helper.service;

import com.helper.core.User;
import com.helper.db.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

/**
 * Created by dvas on 18.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    
    private UserService userService;
    
    @Mock
    SqlSessionFactory mockSessionFactory;
    @Mock
    SqlSession mockSqlSession;
    @Mock
    UserDao mockUserDao;
    
    User stubUser;
    
    
    @Before
    public void setUp () throws Exception {
        
        userService = mock(UserService.class);
        
        stubUser = new User(42, "admin@mock.com", "Stubbed", "User");
        
    }
    
    @After
    public void tearDown () throws Exception {
        stubUser = null;
        
    }
    
    @Test
    public void getUser_should_return_valid_output () throws Exception {
    
        User expectedUser = new User(42, "admin@mock.com", "Stubbed", "User");
        
        when(mockSessionFactory.openSession()).thenReturn(mockSqlSession);
        when(mockSqlSession.getMapper(UserDao.class)).thenReturn(mockUserDao);
        when(mockUserDao.getUser(42)).thenReturn(stubUser);
        
        UserService userService = new UserService(mockSessionFactory);
        
        assertEquals(expectedUser, userService.getUser(42));
    }
    
    @Test
    public void createUser () throws Exception {
        
    }
    
}