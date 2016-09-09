package com.helper.finance.service.impl;

import com.google.common.base.Preconditions;
import com.helper.finance.dto.AccountDto;
import com.helper.finance.dto.converters.AccountDtoConverter;
import com.helper.finance.model.mongodb.Account;
import com.helper.finance.model.mongodb.repository.AccountRepository;
import com.helper.finance.service.AccountService;
import com.helper.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        /*Preconditions.checkArgument(accountDto != null, "Account should not be null");

        if (!userService.userExists(accountDto.getUserId()))
            throw new IllegalArgumentException(String.format("User with id '%s' does not exist or inactive", accountDto.getUserId()));

        Account newAccount = AccountDtoConverter.convertToModel(accountDto);
        newAccount.setId(null);
        newAccount = accountRepository.save(newAccount);*/

        return null; // AccountDtoConverter.convertToDto(newAccount);
    }

    @Override
    public void updateAccount(AccountDto newAccount) {
        Preconditions.checkArgument(newAccount != null, "Account should not be null");

        if (!accountRepository.exists(newAccount.getId()))
            throw new IllegalArgumentException(String.format("Account with id '%s' does not exist", newAccount.getId()));

        accountRepository.save(AccountDtoConverter.convertToModel(newAccount));
    }

    @Override
    public List<AccountDto> getUserAccounts(String userId) {

       /* if (!userService.userExists(userId))
            throw new IllegalArgumentException(String.format("User with id '%s' does not exist or inactive", userId));*/

        return AccountDtoConverter.convertListToDtos(accountRepository.findByUserId(userId));

    }
}
