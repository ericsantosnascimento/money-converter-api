package com.money.exception.handler;

import com.money.exception.MoneyConverterException;
import com.money.exception.ResponseError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eric.nascimento on 28/11/16.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MoneyConverterException.class)
    public ResponseError handleBusinessException(MoneyConverterException e) {
        log.error("An error occurred, {}", e.getMessage());
        return new ResponseError(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ResponseError handleUncaughtException(Exception e) {
        log.error("Uncaught exception, message={}", e.getMessage(), e);
        return new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
    }

}