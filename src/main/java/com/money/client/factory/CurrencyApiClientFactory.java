package com.money.client.factory;

import com.money.client.CurrencyApiClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;

/**
 * Created by eric on 28/11/16.
 */
public class CurrencyApiClientFactory {

    /**
     * build CurrencyApiClient instance
     *
     * @param endpoint the enpoint to connect to the server
     *                 with timeout be reached
     * @return CurrencyApiClient instance
     */
    public static CurrencyApiClient factory(String endpoint) {

        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(new OkHttpClient())
                .target(CurrencyApiClient.class, endpoint);
    }

}
