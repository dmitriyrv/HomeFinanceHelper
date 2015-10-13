package com.helper.finance.service;

import com.helper.finance.dto.CurrencyDto;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */
public interface CurrencyService {
    CurrencyDto addCurrency(CurrencyDto currencyDto);
    List<CurrencyDto> getUserCurrencies(Integer userId);
}
