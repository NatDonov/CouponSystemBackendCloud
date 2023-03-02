package com.jb.couponsys.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


import org.springframework.stereotype.Service;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.clients.ClientType;
import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.exceptions.ErrorMsg;
import com.jb.couponsys.security.Information;
import com.jb.couponsys.security.LoginResponse;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends ClientService implements CustomerService {



    @Override
    public LoginResponse login(String email, String password) throws CouponSystemException {
        Customer customerFromDb = customerRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new CouponSystemException(ErrorMsg.CUSTOMER_EMAIL_OR_PASSWORD));
        Information information = Information.builder().id(customerFromDb.getId()).email(email).clientType(ClientType.CUSTOMER).expirationTime(LocalDateTime.now().plusHours(1)).build();
        UUID token = tokenManager.addToken(information);
        return LoginResponse.builder().email(email).name(customerFromDb.getFirstName()).token(token).clientType(ClientType.CUSTOMER).id(customerFromDb.getId()).build();
    }

    @Override
    public Coupon purchaseCoupon(UUID token, Coupon coupon) throws CouponSystemException {
        int customerId = tokenManager.getCustomerId(token);

        Coupon couponFromDb = couponRepository.findById(coupon.getId()).orElseThrow(()-> new CouponSystemException(ErrorMsg.NOT_EXIST_COUPON));

        if (coupon.getAmount() <= 0) {
            throw new CouponSystemException(ErrorMsg.COUPON_OUT_OF_STOCK);
        }
        if ((coupon.getEndDate().before(Date.valueOf(LocalDate.now())))) {
            throw new CouponSystemException(ErrorMsg.COUPON_EXPIRED);
        }
        if (couponRepository.existsByCustomerIdAndCouponId(customerId, coupon.getId()) == 1) {
            throw new CouponSystemException(ErrorMsg.COUPON_PURCHASED);
        }

        couponFromDb.setAmount(couponFromDb.getAmount() - 1);
        couponRepository.addPurchasedCoupon(customerId, couponFromDb.getId());
        return couponRepository.saveAndFlush(couponFromDb);

    }


    @Override
    public List<Coupon> getCustomerCoupon(UUID token) throws CouponSystemException {
      int customerId = tokenManager.getCustomerId(token);
      return couponRepository.findCustomerPurchaseCoupons(customerId);
    }

    @Override
    public List<Coupon> getCustomerCouponByCategory(UUID token, Category category) throws CouponSystemException {
      int customerId = tokenManager.getCustomerId(token);
      return couponRepository.findCustomerCouponsByCategory(category.name(), customerId);
    }

    @Override
    public List<Coupon> getCustomerCouponByMaxPrice(UUID token, double maxPrice) throws CouponSystemException {
      int customerId = tokenManager.getCustomerId(token);
      return couponRepository.findCustomerCouponsPriceLessThan(customerId, maxPrice);
    }

    @Override
    public Customer getCustomerDetails(UUID token) throws CouponSystemException {
      int customerId = tokenManager.getCustomerId(token);
      List<Coupon> coupons = couponRepository.findCustomerPurchaseCoupons(customerId);
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CouponSystemException(ErrorMsg.NOT_EXIST_CUSTOMER));
        customer.setCoupons(coupons);
        return customer;
    }

    @Override
    public List<Coupon> getAllCoupons() throws CouponSystemException {
      return couponRepository.findAll();
    }
}



