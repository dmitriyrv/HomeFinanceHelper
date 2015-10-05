package com.helper.finance.service.impl;

import com.helper.finance.dto.AccountDto;
import com.helper.finance.dto.converters.AccountDtoConverter;
import com.helper.finance.model.mongodb.Account;
import com.helper.finance.model.mongodb.repository.AccountRepository;
import com.helper.finance.service.AccountService;
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

    @Override
    public void createAccount(AccountDto accountDto) {

    }

    @Override
    public void deleteAccount(AccountDto accountDto) {

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return AccountDtoConverter.convertListToDtos(accountRepository.findAll());
    }

    @Override
    public AccountDto getAccountsByNumber(String accountNumber) {
        List<Account> accounts = accountRepository.findByNumber(accountNumber);


        return null;
    }
}
