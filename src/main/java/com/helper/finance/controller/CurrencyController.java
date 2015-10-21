package com.helper.finance.controller;

import com.helper.finance.dto.CurrencyDto;
import com.helper.finance.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */
@RestController
@RequestMapping("/curr")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CurrencyDto> addCurrency(@RequestBody CurrencyDto newCurrencyDto) {

        CurrencyDto createdCurrencyDto = currencyService.addCurrency(newCurrencyDto);
        return new ResponseEntity<>(createdCurrencyDto, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<Object> getUserCurrenciesList(@RequestParam Integer userId){
        List<CurrencyDto> userCurrencies = currencyService.getUserCurrencies(userId);
        return new ResponseEntity<>(userCurrencies, HttpStatus.OK);
    }

}
