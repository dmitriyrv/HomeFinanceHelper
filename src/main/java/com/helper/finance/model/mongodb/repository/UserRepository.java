package com.helper.finance.model.mongodb.repository;

import com.helper.finance.model.mongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 05.10.2015.
 */

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmailAndActive(String email, boolean active);
    User findByIdAndActive(String id, boolean active);


}
