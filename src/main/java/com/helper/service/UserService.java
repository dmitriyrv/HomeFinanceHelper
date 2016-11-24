package com.helper.service;

import com.helper.core.User;
import com.helper.db.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Optional;

/**
 * Created by dvas on 18.11.2016.
 */
public class UserService {
    private SqlSessionFactory sessionFactory;
    
    public UserService (SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public User getUser(Integer userId){
        SqlSession sqlSession = sessionFactory.openSession();
    
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            
            return userDao.getUser(userId);
        } finally {
            sqlSession.close();
        }
    }
    
    public User createUser(User newUser){
        if (newUser == null) {
            throw new IllegalArgumentException("New user should not be NULL");
        }
    
        SqlSession sqlSession = sessionFactory.openSession();
    
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.createUser(newUser);
            sqlSession.commit();
            return newUser;
        } finally {
            sqlSession.close();
        }
    }
}
