package com.helper.service;

import com.helper.core.Account;
import com.helper.db.AccountDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by dvas on 08.11.2016.
 */
public class AccountService {
    private SqlSessionFactory sessionFactory;
    
    
    public AccountService (SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Account insertAccount(Account newAccount){
        if (newAccount == null){
            throw new IllegalArgumentException("Inserting currency should not be NULL");
        }
    
        SqlSession sqlSession = sessionFactory.openSession();
    
    
        try {
            AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
            accountDao.addAccount(newAccount);
            sqlSession.commit();
            return this.getAccount(newAccount.getAccountId());
        } finally {
            sqlSession.close();
        }
    }
    
    public Account getAccount(int id){
        SqlSession sqlSession = sessionFactory.openSession();
        
        try {
            AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
            return accountDao.getAccountById(id);
        } finally {
            sqlSession.close();
        }
    }
}
