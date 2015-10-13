package com.helper.finance.dto.converters;

import com.helper.finance.dto.CurrencyDto;
import com.helper.finance.model.mysql.Currency;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */
public class CurrencyDtoConverter {
    public static Currency convertToModel(CurrencyDto currencyDto){
        Currency currency = new Currency();
        BeanUtils.copyProperties(currencyDto, currency);
        return currency;
    }

    public static List<Currency> convertListToModels(List<CurrencyDto> currencyDtos){
        List<Currency> currencies = new ArrayList<>();
        currencyDtos.forEach(currencyDto -> currencies.add(CurrencyDtoConverter.convertToModel(currencyDto)));
        return currencies;
    }

    public static CurrencyDto convertToDto(Currency currency){
        CurrencyDto currencyDto = new CurrencyDto();
        BeanUtils.copyProperties(currency, currencyDto);
        return currencyDto;
    }

    public static List<CurrencyDto> convertListToDtos(List<Currency> currencies){
        List<CurrencyDto> currencyDtos = new ArrayList<>();
        currencies.forEach(currency -> currencyDtos.add(CurrencyDtoConverter.convertToDto(currency)));
        return currencyDtos;
    }
}
