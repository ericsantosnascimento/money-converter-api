package com.money.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.math.BigDecimal;
import java.util.Map;

/**
 * User template for immutables, using this template immutable will take care of the boiler plate code (getters, setters) also immutable will override to string e hashcode
 * also User will be immutable.
 * <p>
 * Created by eric.nascimento on 2/18/16.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableCurrencyApiResponse.class)
@JsonDeserialize(as = ImmutableCurrencyApiResponse.class)
public interface CurrencyApiResponse {

    boolean success();

    String terms();

    String privacy();

    String source();

    Map<String, BigDecimal> quotes();

}