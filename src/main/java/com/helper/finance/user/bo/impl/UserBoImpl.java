package com.helper.finance.user.bo.impl;

import com.helper.finance.user.bo.UserBo;
import com.helper.finance.user.dao.UserDao;
import com.helper.finance.user.model.User;

/**
 * Created by dvas on 06.09.2016.
 */
public class UserBoImpl implements UserBo {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findByemail(String email) {
        return userDao.findByemail(email);
    }
}
