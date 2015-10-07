package com.helper.finance.controller;

import com.helper.finance.dto.UserDto;
import com.helper.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody UserDto userInfo){
        try {
            UserDto createdUser = userService.createUser(userInfo);
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>("Database unreachable", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

}
