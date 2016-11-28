package com.money.exception;

/**
 *
 * Created by eric.nascimento on 28/11/16.
 */
public class MoneyConverterException extends RuntimeException {

    public MoneyConverterException(String message) {
        super(message);
    }

    public MoneyConverterException(String message, Exception ex) {
        super(message, ex);
    }
}
