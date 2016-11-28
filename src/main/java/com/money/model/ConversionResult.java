package com.money.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.joda.money.Money;

import java.math.BigDecimal;

/**
 * User template for immutables, using this template immutable will take care of the boiler plate code (getters, setters) also immutable will override to string e hashcode
 * also User will be immutable.
 *
 * Created by eric.nascimento on 2/18/16.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableConversionResult.class)
@JsonDeserialize(as = ImmutableConversionResult.class)
public interface ConversionResult {

    String from();

    String to();

    BigDecimal amount();

}