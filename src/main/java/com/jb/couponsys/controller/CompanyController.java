package com.jb.couponsys.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.service.CompanyService;

@RestController
@RequestMapping("api/company")
@CrossOrigin("*")


public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/coupons")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@RequestHeader("Authorization") UUID token,  @RequestBody Coupon coupon) throws CouponSystemException {
        companyService.addCoupon(token,  coupon);
    }

    @PutMapping("/coupons/{couponId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@RequestHeader("Authorization") UUID token, @PathVariable int couponId, @RequestBody Coupon coupon) throws CouponSystemException {
        companyService.updateCoupon(token, couponId, coupon);
    }

    @DeleteMapping("/coupons/{couponId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@RequestHeader("Authorization") UUID token, @PathVariable int couponId) throws CouponSystemException {
        companyService.deleteCoupon(token, couponId);
    }


    @GetMapping("/coupons")
    public List<Coupon> getCompanyCoupons(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        return companyService.getCompanyCoupons(token);
    }


    @GetMapping("/coupons/category")
    public List<Coupon> getAllCompaniesByCategory(@RequestHeader("Authorization") UUID token, @RequestParam("category") String category) throws CouponSystemException {
        return companyService.getAllCompanyCouponsByCategory(token, Category.valueOf(category));
    }

    @GetMapping("/coupons/max-price")
    public List<Coupon> getCompanyCouponsByMaxPrice(@RequestHeader("Authorization") UUID token, @RequestParam int maxPrice) throws CouponSystemException {
        return companyService.getCompanyCouponsByMaxPrice(token, maxPrice);
    }


    @GetMapping("/details")
    public Company getCompanyDetails(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        return companyService.getCompanyDetails(token);
    }


    @GetMapping("/{couponId}")
    public Coupon getOneCoupon(@RequestHeader("Authorization") UUID token, @PathVariable int couponId) throws CouponSystemException {
        return companyService.getOneCoupon(token, couponId);
    }


}
