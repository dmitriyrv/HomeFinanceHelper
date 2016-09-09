package com.helper.finance.model.mysql.repository;

import com.helper.finance.model.mysql.User;

/**
 * Created by dvas on 08.09.2016.
 */
public interface UserRepository {
    User getUserInfo(String email);
}
