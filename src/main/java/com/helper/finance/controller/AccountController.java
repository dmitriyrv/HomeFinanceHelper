package com.helper.finance.controller;

import com.helper.finance.dto.AccountDto;
import com.helper.finance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 07.10.2015.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createAccount(@RequestBody AccountDto newAccountDto){
        try {
            AccountDto createdAccountDto = accountService.createAccount(newAccountDto);
            return new ResponseEntity<>(createdAccountDto, HttpStatus.OK);
        } catch (IllegalStateException ise){
            return new ResponseEntity<>("Database unreachable", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException iae){
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getUserAccounts(@RequestParam String userId){
        try {
            List<AccountDto> userAccountDtos = accountService.getUserAccounts(userId);
            return new ResponseEntity<>(userAccountDtos, HttpStatus.OK);
        } catch (IllegalStateException ise){
            return new ResponseEntity<>("Database unreachable", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException iae){
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
