package com.helper.finance.model.mysql.repository;

import com.helper.finance.model.mysql.Currency;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */

public interface CurrencyRepository  {
    Currency addCurrency(Currency currency);
    List<Currency> findByUserId(Integer userId);
}
