package com.helper.finance.model.mysql.repository;

import com.helper.finance.model.mysql.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
    List<Currency> findByUserId(Integer userId);
}
