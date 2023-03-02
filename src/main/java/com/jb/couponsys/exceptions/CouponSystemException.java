package com.jb.couponsys.exceptions;

public class CouponSystemException extends Exception{
    public CouponSystemException(ErrorMsg errormsg) {
        super(errormsg.getMessage());

    }

}
