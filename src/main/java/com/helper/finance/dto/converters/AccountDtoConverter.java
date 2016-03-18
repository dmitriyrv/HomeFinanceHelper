package com.helper.finance.dto.converters;

import com.helper.finance.dto.AccountDto;
import com.helper.finance.model.mongodb.Account;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 01.10.2015.
 */
public class AccountDtoConverter {
    public static Account convertToModel(AccountDto accountDto){
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        return account;
    }

    public static List<Account> convertListToModels(List<AccountDto> accountDtos){
        List<Account> accounts = new ArrayList<>();

        for (AccountDto accDto : accountDtos ) {
            accounts.add(AccountDtoConverter.convertToModel(accDto));
        }

        return accounts;
    }

    public static AccountDto convertToDto(Account account){
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account, accountDto);
        return accountDto;
    }

    public static List<AccountDto> convertListToDtos(List<Account> accounts){
        List<AccountDto> accountDtos = new ArrayList<>();

        for (Account acc : accounts) {
            accountDtos.add(AccountDtoConverter.convertToDto(acc));
        }

        return accountDtos;
    }
}
