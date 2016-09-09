package com.helper.finance.model.mysql.repository.impl;

import com.google.common.base.Preconditions;
import com.helper.finance.model.mysql.User;
import com.helper.finance.model.mysql.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dvas on 08.09.2016.
 */
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserInfo(String email) {

        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("FROM Users usr where usr.email=:email").setParameter("email", email).list();
        return users.get(0);
    }
}
