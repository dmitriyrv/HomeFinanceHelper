package com.helper.finance.service.impl;

import com.helper.finance.dto.UserDto;
import com.helper.finance.dto.converters.UserDtoConverter;
import com.helper.finance.model.mongodb.User;
import com.helper.finance.model.mongodb.repository.UserRepository;
import com.helper.finance.service.UserService;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public UserDto createUser(UserDto newUserDto) {
        User newUser;
        try {
            newUser = userRepository.findByEmailAndActive(newUserDto.getEmail(), true);
            if (newUser == null) {

                newUserDto.setId(null); //to let MongoDB create autoID
                newUserDto.setPassword(DigestUtils.sha512Hex(newUserDto.getPassword()));
                newUser = userRepository.save(UserDtoConverter.convertToModel(newUserDto));

            }
        } catch (DataAccessResourceFailureException e) {
            throw new IllegalStateException();
        }

        return UserDtoConverter.convertToDto(newUser);
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

        return userToAuthenticate != null && (userToAuthenticate.getPassword()).equals(DigestUtils.sha512Hex(password));

    }

    @Override
    public boolean userExists(String userId) {
        User user = null;
        try {
            user = userRepository.findOne(userId);
            if (user == null || !user.isActive())
                return false;
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return (user != null);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users = userRepository.findAll();
        return UserDtoConverter.convertListToDtos(users);
    }

    @Override
    public UserDto getUserById(String userId) {
        return UserDtoConverter.convertToDto(userRepository.findOne(userId));
    }
}
