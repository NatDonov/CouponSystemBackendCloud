package com.jb.couponsys.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.service.CustomerService;

@RestController
@RequestMapping("api/customer")
@CrossOrigin("*")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/coupons")
  public List<Coupon> getCustomerCoupons(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
    return customerService.getCustomerCoupon(token);
  }

  @GetMapping("/coupons/category")
  public List<Coupon> getCustomerCouponsByCategory(@RequestHeader("Authorization") UUID token,
      @RequestParam("category") String category) throws CouponSystemException {
    return customerService.getCustomerCouponByCategory(token, Category.valueOf(category));
  }

  @GetMapping("/coupons/max-price")
  public List<Coupon> getCustomerCouponsByMaxPrice(@RequestHeader("Authorization") UUID token,
      @RequestParam int maxPrice) throws CouponSystemException {
    return customerService.getCustomerCouponByMaxPrice(token, maxPrice);
  }

  @GetMapping("/details")
  public Customer getCustomerDetails(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
    return customerService.getCustomerDetails(token);
  }

  @PostMapping("/coupons")
  @ResponseStatus(HttpStatus.CREATED)
  public Coupon purchaseCoupon(@RequestHeader("Authorization") UUID token, @RequestBody Coupon coupon)
      throws CouponSystemException {
    return customerService.purchaseCoupon(token, coupon);
  }

  @GetMapping("/allcoupons")
  public List<Coupon> getAllCoupons() throws CouponSystemException {
    return customerService.getAllCoupons();
  }

}
