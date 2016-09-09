package com.helper.finance.service;

import com.helper.finance.dto.UserDto;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */
public interface UserService {
    UserDto getUserInfo(String email);
    /*UserDto createUser(UserDto newUser);
    void updateUser( UserDto newUser);
    UserDto getUserById(String userId);


    void changeUserActiveState(UserDto user, boolean newState);

    boolean authenticateUser(String email, String password);
    boolean userExists(String userId);

    List<UserDto> getAllUsers();*/
}
