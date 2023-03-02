package com.jb.couponsys.exceptions;

import org.springframework.http.HttpStatus;

public enum ErrorMsg {

    COMPANY_NAME_EXIST("cannot add company with existing name"),
    COMPANY_EMAIL_EXIST("cannot add company with existing email"),
    COMPANY_EXIST("company already exist"),
    ADMIN_LOGIN_ERROR("login error, email or password not exist"),
    CUSTOMER_EXIST("customer already exist"),
    CUSTOMER_EMAIL_EXIST("cannot add customer with existing email"),
    COMPANY_EMAIL_OR_PASSWORD("Login error, email or password not exist"),
    CUSTOMER_EMAIL_OR_PASSWORD("Login error, email or password not exist"),
    COUPON_TITLE_EXIST("cannot add coupon with existing title"),
    COUPON_OUT_OF_STOCK("Coupon purchased"),
    COUPON_EXPIRED("Sorry, coupon has expired"),
    NOT_EXIST_COMPANY("Error, the company does not exist"),
    NOT_EXIST_COUPON("Error, the coupon does not exist"),
    NOT_EXIST_CUSTOMER("Error, the customer does not exist"),
    COMPANY_UPDATE_ID("Error, cannot update company`s id"),
    COMPANY_UPDATE_NAME("Error, cannot update company`s name"),
    CUSTOMER_UPDATE_ID("Error, cannot update customer`s id"),
    COUPON_UPDATE_ID("Error, cannot update coupon`s id"),
    COUPON_PURCHASED("Coupon already purchased, you cannot purchase it again"),
    INVALID_CLIENT_TYPE("Client type is not supported"),
    LOGIN_FAILED("Failed to login"),
    INVALID_COUPON_UPDATE("can`t update coupon"),

    TOKEN_NOT_VALID("Token is not valid"),

    UNAUTHORIZED_ACTION("Unauthorized action");


    private String message;


    ErrorMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
