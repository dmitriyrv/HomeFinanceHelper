package com.helper.finance.service.impl;

import com.helper.finance.dto.UserDto;
import com.helper.finance.dto.converters.UserDtoConverter;
import com.helper.finance.model.mongodb.User;
import com.helper.finance.model.mongodb.repository.UserRepository;
import com.helper.finance.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserDto newUser) {
        if (userRepository.findByEmailAndActive(newUser.getEmail(), true) != null) {
            newUser.setId("");
            newUser.setPassword(DigestUtils.sha512Hex(newUser.getPassword()));
            userRepository.save(UserDtoConverter.convertToModel(newUser));
        }
    }

    @Override
    public void changeUserActiveState(UserDto user, boolean newState) {
        user.setActive(newState);
        updateUser(user);
    }

    @Override
    public void deleteUser(UserDto user) {

    }

    @Override
    public void updateUser(UserDto newUser) {
        if (userRepository.exists(newUser.getId())){
            userRepository.save(UserDtoConverter.convertToModel(newUser));
        } else {
            throw new IllegalArgumentException(String.format("User with id '%s' does not exist.", newUser.getId()));
        }
    }

    @Override
    public boolean authenticateUser(String email, String password) {

        User userToAuthenticate = userRepository.findByEmailAndActive(email, true);

        if (userToAuthenticate != null && (userToAuthenticate.getPassword()).equals(DigestUtils.sha512Hex(password)))
            return true;

        return false;
    }
}
