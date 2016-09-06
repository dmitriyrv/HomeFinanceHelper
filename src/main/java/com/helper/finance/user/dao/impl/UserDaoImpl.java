package com.helper.finance.user.dao.impl;

import com.helper.finance.user.dao.UserDao;
import com.helper.finance.user.model.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dvas on 06.09.2016.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public void update(User user) {
        getHibernateTemplate().update(user);
    }

    @Override
    public void delete(User user) {
        getHibernateTemplate().delete(user);
    }

    @Override
    public User findByemail(String email) {
        List list = getHibernateTemplate().find("from users where email=&", email);
        return (User) list.get(0);
    }
}
