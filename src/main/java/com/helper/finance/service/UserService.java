package com.helper.finance.service;

import com.helper.finance.dto.UserDto;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */
public interface UserService {
    void createUser(UserDto newUser);
    void changeUserActiveState(UserDto user, boolean newState);
    void deleteUser(UserDto user);
    void updateUser( UserDto newUser);
    boolean authenticateUser(String email, String password);

    List<UserDto> getAllUsers();
}
