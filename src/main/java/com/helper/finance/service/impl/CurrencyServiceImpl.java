package com.helper.finance.service.impl;

import com.helper.finance.dto.CurrencyDto;
import com.helper.finance.dto.converters.CurrencyDtoConverter;
import com.helper.finance.model.mysql.Currency;
import com.helper.finance.model.mysql.repository.CurrencyRepository;
import com.helper.finance.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public CurrencyDto addCurrency(CurrencyDto currencyDto) {
        //TODO: Add nonexistent user handling
        Currency newCurrency = CurrencyDtoConverter.convertToModel(currencyDto);
        return CurrencyDtoConverter.convertToDto(currencyRepository.save(newCurrency));
    }

    @Override
    public List<CurrencyDto> getUserCurrencies(Integer userId) {
        return CurrencyDtoConverter.convertListToDtos(currencyRepository.findByUserId(userId));
    }
}
