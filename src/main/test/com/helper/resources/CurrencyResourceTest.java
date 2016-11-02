package com.helper.resources;

import com.helper.core.Currency;
import com.helper.service.CurrencyService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by dvas on 02.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CurrencyResourceTest {
    
    @InjectMocks
    CurrencyResource resource;
    
    @Mock
    CurrencyService mockCurrencyService;
    @Mock
    Currency mockCurrency;
    
    @Before
    public void setUp(){
    
        when(mockCurrencyService.insertCurrency(any(Currency.class))).thenReturn(42);
        when(mockCurrencyService.getCurrency(42)).thenReturn(mockCurrency);
    }
    
    @After
    public void tearDown(){
        
    }
    
    @Test
    public void addCurrency () throws Exception {
        
    }
    
    @Test
    public void getById () throws Exception {
        
        mockCurrencyService.getCurrency(42);
        assertEquals(mockCurrency, resource.getById(42));
    }
    
    @Test
    public void getCurrencies () throws Exception {
        
    }
    
}