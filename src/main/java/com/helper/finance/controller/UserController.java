package com.helper.finance.controller;

import com.helper.finance.dto.UserDto;
import com.helper.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userInfo) {

        return new ResponseEntity<>(userService.createUser(userInfo), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<Object>(userService.getAllUsers(), HttpStatus.OK);
    }

}
