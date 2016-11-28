package com.money.configuration;

import com.money.client.CurrencyApiClient;
import com.money.client.factory.CurrencyApiClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for CurrencyApiClient
 *
 * Created by eric on 28/11/16.
 */
@Configuration
public class CurrencyApiClientConfiguration {

    @Value("${api.endpoint}")
    private String currencyApiClientUrl;

    @Bean
    public CurrencyApiClient currencyApiClient() {
        return CurrencyApiClientFactory.factory(currencyApiClientUrl);
    }

}
