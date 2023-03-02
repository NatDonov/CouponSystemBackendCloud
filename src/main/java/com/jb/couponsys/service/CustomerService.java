package com.jb.couponsys.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.exceptions.CouponSystemException;

@Service
public interface CustomerService {

  Coupon purchaseCoupon(UUID token, Coupon coupon) throws CouponSystemException;

  List<Coupon> getCustomerCoupon(UUID token) throws CouponSystemException;

  List<Coupon> getCustomerCouponByCategory(UUID token, Category category) throws CouponSystemException;

  List<Coupon> getCustomerCouponByMaxPrice(UUID token, double maxPrice) throws CouponSystemException;

  Customer getCustomerDetails(UUID token) throws CouponSystemException;

  List<Coupon> getAllCoupons() throws CouponSystemException;
    
}