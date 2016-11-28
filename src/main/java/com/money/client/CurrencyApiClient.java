package com.money.client;

import com.money.model.ImmutableCurrencyApiResponse;
import feign.FeignException;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Merchant client Api, responsible to provide methods to create, update or retrive Store or Groups
 * <p>
 * Created by eric-nascimento on 28/11/16.
 */
@Headers("Content-Type: application/json")
public interface CurrencyApiClient {

    @RequestLine("GET /live?access_key={api_key}&currencies={currency}")
    ImmutableCurrencyApiResponse getCurrency(@Param("api_key") String apiKey, @Param("currency") String currency) throws FeignException;

}
