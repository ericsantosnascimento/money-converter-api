package com.money.service;

import com.money.client.CurrencyApiClient;
import com.money.exception.MoneyConverterException;
import com.money.model.ImmutableConversionResult;
import com.money.model.ImmutableCurrencyApiResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Mock service resposible to convert the requested value to from current to currency to requested currency
 * <p>
 * Created by eric.nascimento on 28/11/16.
 */
@Service
public class MoneyConverterService {

    private CurrencyApiClient currencyApiClient;

    @Value("${api.access.key}")
    private String apiKey;

    @Autowired
    public MoneyConverterService(CurrencyApiClient currencyApiClient) {
        this.currencyApiClient = currencyApiClient;
    }

    public ImmutableConversionResult convert(String from, String to, BigDecimal amount) throws MoneyConverterException {
        validateInputCurrencies(from, to);
        BigDecimal rate = getCurrencyRate(from, to);
        return ImmutableConversionResult.builder().from(from).to(to).amount(amount.multiply(rate)).build();
    }

    private boolean validateInputCurrencies(String from, String to) {
        if (from.equals("USD") || from.equals("EUR") || from.equals("JPN") && to.equals("USD") || to.equals("EUR") || to.equals("JPN")) {
            return true;
        } else {
            throw new MoneyConverterException("Unsupported currency!");
        }
    }

    private BigDecimal getCurrencyRate(String from, String to) {

        try {
            ImmutableCurrencyApiResponse currency = currencyApiClient.getCurrency("61d23adcb77c9cbc8059a31c87463fd7", to);
            return currency.quotes().get(from + to);
        } catch (FeignException e) {
            throw new MoneyConverterException("Error requesting Currency rate not found!", e);
        } catch (NullPointerException e) {
            throw new MoneyConverterException("Currency rate not found!");
        }

    }
}
