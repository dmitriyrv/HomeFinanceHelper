package com.helper.finance.service;

import com.helper.finance.dto.AccountDto;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 01.10.2015.
 */
public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    void updateAccount(AccountDto newAccount);
    List<AccountDto> getUserAccounts(String userId);
}
