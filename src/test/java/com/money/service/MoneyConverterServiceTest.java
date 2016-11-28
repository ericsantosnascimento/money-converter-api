package com.money.service;

import com.money.client.CurrencyApiClient;
import com.money.exception.MoneyConverterException;
import com.money.model.ImmutableConversionResult;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by eric on 28/11/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MoneyConverterServiceTest {

    @Mock
    private CurrencyApiClient currencyApiClient;

    @Test
    public void convertWithSuccess() throws Exception {
        MoneyConverterService moneyConverterService = Mockito.mock(MoneyConverterService.class);
        Mockito.when(moneyConverterService.convert("USD", "EUR", BigDecimal.ONE)).thenReturn(ImmutableConversionResult.builder().from("USD").to("EUR").amount(new BigDecimal(0.943901)).build());
        ImmutableConversionResult immutableConversionResult = moneyConverterService.convert("USD", "EUR", BigDecimal.ONE);
        Assert.assertThat(immutableConversionResult, is(notNullValue()));
        Assert.assertThat(immutableConversionResult.amount(), is(equalTo(new BigDecimal(0.943901))));
    }

    @Test(expected = MoneyConverterException.class)
    public void convertWithoutSuccessUnsupportedInput() throws Exception {
        MoneyConverterService moneyConverterService = new MoneyConverterService(currencyApiClient);
        moneyConverterService.convert("USD", "EUR", BigDecimal.ONE);
    }

}