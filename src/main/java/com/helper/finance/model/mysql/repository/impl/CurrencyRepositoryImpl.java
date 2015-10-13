package com.helper.finance.model.mysql.repository.impl;

import com.helper.finance.model.mysql.Currency;
import com.helper.finance.model.mysql.repository.CurrencyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */
@Service
@Transactional
public class CurrencyRepositoryImpl implements CurrencyRepository {

   @Resource(name="sessionFactory")
   private SessionFactory sessionFactory;

    @Override
    public Currency addCurrency(Currency currency) {

        Session session = sessionFactory.getCurrentSession();

        return (Currency) session.save(currency);
    }

    @Override
    public List<Currency> findByUserId(Integer userId) {
        return null;
    }
}
