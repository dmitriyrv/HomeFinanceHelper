package com.helper.service;

import com.helper.core.Currency;
import com.helper.db.CurrencyDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by dvas on 31.10.2016.
 */
public class CurrencyService {
    
    private SqlSessionFactory sessionFactory;
    
    public CurrencyService(SqlSessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public int insertCurrency (Currency newCurrency){
        
        if (newCurrency == null){
            throw new IllegalArgumentException("Inserting currency should not be NULL");
        }
        
        SqlSession sqlSession = sessionFactory.openSession();
        
        
        try {
            CurrencyDao currencyDao = sqlSession.getMapper(CurrencyDao.class);
            currencyDao.addCurrency(newCurrency);
            sqlSession.commit();
            return newCurrency.getId();
        } finally {
            sqlSession.close();
        }
        
    }
    
    public Currency getCurrency(int id){
        SqlSession sqlSession = sessionFactory.openSession();
        
        try {
            CurrencyDao currencyDao = sqlSession.getMapper(CurrencyDao.class);
            return currencyDao.getCurrencyById(id);
        } finally {
            sqlSession.close();
        }
    }
    
    public List<Currency> getAllCurrencies(){
        SqlSession sqlSession = sessionFactory.openSession();
        
        try {
            CurrencyDao currencyDao = sqlSession.getMapper(CurrencyDao.class);
            return currencyDao.getAllCurrencies();
        } finally {
            sqlSession.close();
        }
    }
}
