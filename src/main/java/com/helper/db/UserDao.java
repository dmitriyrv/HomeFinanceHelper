package com.helper.db;

import com.helper.core.User;

import java.util.Optional;

/**
 * Created by dvas on 16.11.2016.
 */
public interface UserDao {
    Optional<User> getUser (Integer userId);
}
