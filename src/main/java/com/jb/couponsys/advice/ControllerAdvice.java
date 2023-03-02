package com.jb.couponsys.advice;

import com.jb.couponsys.exceptions.CouponSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = {CouponSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails handlerError(Exception e){
        return ErrDetails.builder().value(e.getMessage()).build();
    }


//    @ExceptionHandler(value = {CouponSystemException.class})
//    public ResponseEntity<?> handleError(CouponSystemException e) {
//        ErrDetails err = ErrDetails.builder().value(e.getMessage()).build();
//        HttpStatus status = ;
//        return new ResponseEntity<>(err, status);
//    }
}