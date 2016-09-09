package com.helper.finance.controller;

import com.helper.finance.configuration.SecurityConfig;
import com.helper.finance.dto.UserDto;
import com.helper.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private SecurityConfig securityConfig;


    /*@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userInfo) {

        return new ResponseEntity<>(userService.createUser(userInfo), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto user) throws Exception {

        UserDto userDto = userService.getUserInfo(user.getEmail());

        UserDetails uds = securityConfig.userDetailsServiceBean().loadUserByUsername(user.getEmail());

        Authentication auth = new UsernamePasswordAuthenticationToken(uds.getUsername(), uds.getPassword(), uds.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return new ResponseEntity<>(userDto, HttpStatus.OK);

    }

}
