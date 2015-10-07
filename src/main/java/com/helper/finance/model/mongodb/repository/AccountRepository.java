package com.helper.finance.model.mongodb.repository;

import com.helper.finance.model.mongodb.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 01.10.2015.
 */

public interface AccountRepository extends MongoRepository<Account, String> {
   List<Account> findByUserId(String userId);

}
