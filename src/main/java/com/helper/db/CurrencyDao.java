package com.helper.db;

import com.helper.core.Currency;

import java.util.List;

/**
 * Created by dvas on 27.10.2016.
 */

public interface CurrencyDao {
    
    void addCurrency(Currency newCurrency);
    List<Currency> getAllCurrencies();
    Currency getCurrencyById(int id);
}
