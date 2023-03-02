package com.jb.couponsys.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.exceptions.CouponSystemException;

@Service
public interface CompanyService {

    void deleteCoupon(UUID token, int couponId) throws CouponSystemException;

    void addCoupon(UUID token, Coupon coupon) throws CouponSystemException;

    void updateCoupon(UUID token, int couponId, Coupon coupon) throws CouponSystemException;

    List<Coupon> getCompanyCoupons(UUID token) throws CouponSystemException;

    List<Coupon> getAllCompanyCouponsByCategory(UUID token, Category category) throws CouponSystemException;

    List<Coupon> getCompanyCouponsByMaxPrice(UUID token, double price) throws CouponSystemException;

    Company getCompanyDetails(UUID token) throws CouponSystemException;

    Coupon getOneCoupon(UUID token, int couponId) throws CouponSystemException;


}
