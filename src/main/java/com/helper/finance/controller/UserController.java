package com.helper.finance.controller;

import com.helper.finance.dto.UserDto;
import com.helper.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody UserDto userInfo){
        userService.createUser(userInfo);
        return new ResponseEntity<>("user created", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public @ResponseBody ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

}
