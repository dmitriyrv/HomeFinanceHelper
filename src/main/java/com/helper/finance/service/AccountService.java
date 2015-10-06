package com.helper.finance.service;

import com.helper.finance.dto.AccountDto;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 01.10.2015.
 */
public interface AccountService {
    void createAccount(AccountDto accountDto);
    void deleteAccount(AccountDto accountDto);

    //TODO: update functionality and...

    List<AccountDto> getAllAccounts();
    AccountDto getAccountsByNumber(String accountNumber);


}
