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
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by dvas on 02.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CurrencyServiceTest {
    
    
    private CurrencyService service;
    
    @Mock
    SqlSessionFactory mockSessionFactory;
    @Mock
    SqlSession mockSqlSession;
    @Mock
    CurrencyDao mockCurrencyDao;
    
    Currency expectedCurrency;
    
    
    @Before
    public void setUp () throws Exception {
    
        service = mock(CurrencyService.class);
        
        expectedCurrency = new Currency(42,42,"QQQ","WWW",42,1.2F);
        
        when(mockSessionFactory.openSession()).thenReturn(mockSqlSession);
        when(mockSqlSession.getMapper(CurrencyDao.class)).thenReturn(mockCurrencyDao);
        doNothing().when(mockCurrencyDao).addCurrency(new Currency());
        when(mockCurrencyDao.getCurrencyById(42)).thenReturn(expectedCurrency);
        doNothing().when(mockSqlSession).commit(); //not sure if it is necessary
        
        
    }
    
    @After
    public void tearDown () throws Exception {
        expectedCurrency = null;
    }
    
    @Test
    public void insertCurrency () throws Exception {
        
        CurrencyService currencyService = new CurrencyService(mockSessionFactory);
        
        assertEquals(0, currencyService.insertCurrency(new Currency()));
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void insertCurrencyShouldThrowExceptionForNullArgument () throws Exception {
        service.insertCurrency(null);
    }
    
    @Test
    public void getCurrencyShouldReturnValidOutput () throws Exception {
        
        CurrencyService service = new CurrencyService(mockSessionFactory);
        assertEquals(expectedCurrency, service.getCurrency(42));
        
    }
    
    @Test
    public void getAllCurrencies () throws Exception {
        
    }
    
   
    
}