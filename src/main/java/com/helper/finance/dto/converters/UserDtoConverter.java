package com.helper.finance.dto.converters;

import com.helper.finance.dto.UserDto;
import com.helper.finance.model.mongodb.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */
public class UserDtoConverter {

    public static User convertToModel(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    public static List<User> convertListToModels(List<UserDto> userDtos){
        List<User> users = new ArrayList<>();
        userDtos.forEach(userDto -> users.add(UserDtoConverter.convertToModel(userDto)));
        return users;
    }

    public static UserDto convertToDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setPassword("");
        return userDto;
    }

    public static List<UserDto> convertListToDtos(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> userDtos.add(UserDtoConverter.convertToDto(user)));
        return userDtos;
    }

}
