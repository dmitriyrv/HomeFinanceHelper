package com.helper.finance.user.dao;

import com.helper.finance.user.model.User;

/**
 * Created by dvas on 06.09.2016.
 */
public interface UserDao {
    void save(User user);
    void update(User user);
    void delete(User user);
    User findByemail(String email);
}
