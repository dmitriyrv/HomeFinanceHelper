package com.helper.service;

import com.helper.core.Currency;
import com.helper.db.CurrencyDao;
import com.helper.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by dvas on 31.10.2016.
 */
public class CurrencyService {
    
    public void insertCurrency (Currency newCurrency){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        Currency createdCurrency = new Currency();
        
        try {
            CurrencyDao currencyDao = sqlSession.getMapper(CurrencyDao.class);
            currencyDao.addCurrency(newCurrency);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        
    }
    
    public Currency getCurrency(int id){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        
        try {
            CurrencyDao currencyDao = sqlSession.getMapper(CurrencyDao.class);
            return currencyDao.getCurrencyById(id);
        } finally {
            sqlSession.close();
        }
    }
    
    public List<Currency> getAllCurrencies(){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        
        try {
            CurrencyDao currencyDao = sqlSession.getMapper(CurrencyDao.class);
            return currencyDao.getAllCurrencies();
        } finally {
            sqlSession.close();
        }
    }
}
