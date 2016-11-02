package com.helper.service;

import com.helper.core.Currency;
import com.helper.db.CurrencyDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by dvas on 02.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CurrencyServiceTest {
    
    @InjectMocks
    CurrencyService service;
    
    @Mock
    SqlSessionFactory mockSessionFactory;
    @Mock
    SqlSession mockSqlSession;
    @Mock
    CurrencyDao mockCurrencyDao;
    @Mock
    Currency mockCurrency;
    
    @Before
    public void setUp () throws Exception {
        when(mockSessionFactory.openSession()).thenReturn(mockSqlSession);
        when(mockSqlSession.getMapper(CurrencyDao.class)).thenReturn(mockCurrencyDao);
        doNothing().when(mockSqlSession).commit(); //not sure if it is necessary
    }
    
    @After
    public void tearDown () throws Exception {
        
    }
    
    @Test
    public void insertCurrency () throws Exception {
        doNothing().when(mockCurrencyDao).addCurrency(any(Currency.class));
        when(service.insertCurrency(mockCurrency)).thenReturn(16);
        
        assertEquals(16, service.insertCurrency(mockCurrency));
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void insertCurrencyShouldThrowExceptionForNullArgument () throws Exception {
        service.insertCurrency(null);
    }
    
    @Test
    public void getCurrencyShouldReturnValidOutput () throws Exception {
        Currency currency = service.getCurrency(9);
        assertNotNull(currency);
    }
    
    @Test
    public void getAllCurrencies () throws Exception {
        
    }
    
}