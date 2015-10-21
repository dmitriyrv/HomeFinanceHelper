package com.helper.finance.model.mysql.repository.impl;

import com.helper.finance.model.mysql.Currency;
import com.helper.finance.model.mysql.repository.CurrencyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */
@Repository
@Transactional
public class CurrencyRepositoryImpl implements CurrencyRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Currency addCurrency(Currency currency) {

        Session session = sessionFactory.getCurrentSession();
        Integer newCurrencyId = (Integer) session.save(currency);
        Currency savedCurrency = session.get(Currency.class, newCurrencyId);
        return savedCurrency;
    }

    @Override
    public List<Currency> findByUserId(Integer userId) {

        Session session = sessionFactory.getCurrentSession();
        List<Currency> userCurrencies = session.createQuery("FROM Currency curr where curr.userId=:userId")
                .setParameter("userId", userId)
                .list();
        return userCurrencies;
    }


}
