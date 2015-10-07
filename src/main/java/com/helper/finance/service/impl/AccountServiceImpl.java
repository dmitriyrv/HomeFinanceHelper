package com.helper.finance.service.impl;

import com.helper.finance.dto.AccountDto;
import com.helper.finance.dto.UserDto;
import com.helper.finance.dto.converters.AccountDtoConverter;
import com.helper.finance.model.mongodb.Account;
import com.helper.finance.model.mongodb.repository.AccountRepository;
import com.helper.finance.service.AccountService;
import com.helper.finance.service.UserService;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 01.10.2015.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserService userService;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account newAccount;
        try {
            if (!userService.userExists(accountDto.getUserId()))
                throw new IllegalArgumentException(String.format("User with id '%s' does not exist or inactive", accountDto.getUserId()));


            accountDto.setId(null);
            newAccount = accountRepository.save(AccountDtoConverter.convertToModel(accountDto));


        } catch (DataAccessResourceFailureException e) {
            throw new IllegalStateException();
        }

        return AccountDtoConverter.convertToDto(newAccount);
    }

    @Override
    public void updateAccount(AccountDto newAccount) {
        if (!accountRepository.exists(newAccount.getId())){
            accountRepository.save(AccountDtoConverter.convertToModel(newAccount));
        } else {
            throw new IllegalArgumentException(String.format("Account with id '%s' does not exist", newAccount.getId()));
        }
    }

    @Override
    public List<AccountDto> getUserAccounts(String userId) {

        if (!userService.userExists(userId))
            throw new IllegalArgumentException(String.format("User with id '%s' does not exist or inactive", userId));

        List<AccountDto> userAccounts;
        try {
            userAccounts = AccountDtoConverter.convertListToDtos(accountRepository.findByUserId(userId));
        } catch (DataAccessResourceFailureException e) {
            throw new IllegalStateException();
        }
        // return (userAccounts == null ? Collections.emptyList() : userAccounts);
        return userAccounts;
    }
}
