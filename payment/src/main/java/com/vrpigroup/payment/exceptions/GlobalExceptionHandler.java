package com.vrpigroup.payment.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    /*public GlobalExceptionHandler(String s) {
        super(s);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
            return e.getMessage();
        }*/

}
