package com.helper.finance.model.mongodb.repository;

import com.helper.finance.model.mongodb.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 01.10.2015.
 */

public interface AccountRepository extends MongoRepository<Account, String> {
   List<Account> findByUser(String userId);
   List<Account> findByNumber(String accountNumber);
   List<Account> findByType(String type);
   List<Account> findByCurrency(String currency);
}
