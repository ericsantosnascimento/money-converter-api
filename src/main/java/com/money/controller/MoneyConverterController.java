package com.money.controller;

import com.money.model.ImmutableConversionResult;
import com.money.service.MoneyConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * MoneyConverterController API use this to convert money from currency to other currency
 * <p>
 * Created by eric on 28/11/16.
 */
@RestController
@RequestMapping("currencies")
public class MoneyConverterController {

    private static final Logger logger = LoggerFactory.getLogger(MoneyConverterController.class);
    private MoneyConverterService moneyConverterService;

    @Autowired
    public MoneyConverterController(MoneyConverterService moneyConverterService) {
        this.moneyConverterService = moneyConverterService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ImmutableConversionResult convertMoney(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) {
        return moneyConverterService.convert(from, to,  amount);
    }

}
