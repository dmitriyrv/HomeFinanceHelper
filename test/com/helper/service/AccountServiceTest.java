package com.helper.service;

import com.helper.core.Account;
import com.helper.core.Currency;
import com.helper.db.AccountDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by dvas on 16.11.2016.
 */
public class AccountServiceTest {
    
    private AccountService service;
    
    @Mock
    SqlSessionFactory mockSessionFactory;
    @Mock
    SqlSession mockSqlSession;
    @Mock
    AccountDao mockAccountDao;
    
    Account expectedAccount;
    
    @Before
    public void setUp () throws Exception {
        service = mock(AccountService.class);
        expectedAccount = new Account(42, new Currency(42,42,"QQQ","WWW",42,1.2F),42,"My acc");
        
        /*when(mockSessionFactory.openSession()).thenReturn(mockSqlSession);
        when(mockSqlSession.getMapper(AccountDao.class)).thenReturn(mockAccountDao);*/
        //when(mockAccountDao.addAccount(any(Account.class)))
        
    }
    
    @After
    public void tearDown () throws Exception {
        expectedAccount = null;
    }
    
    @Test
    public void insertAccount_should_return_valid_output () throws Exception {
        
    }
    
    @Test
    public void getAccount () throws Exception {
        
    }
    
}