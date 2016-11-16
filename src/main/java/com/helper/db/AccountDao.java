package com.helper.db;

import com.helper.core.Account;

/**
 * Created by dvas on 07.11.2016.
 */
public interface AccountDao {
    void addAccount(Account newAccount);
    Account getAccountById(int id);
}
