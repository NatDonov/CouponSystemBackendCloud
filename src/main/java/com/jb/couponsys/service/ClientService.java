package com.jb.couponsys.service;

import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.repos.CompanyRepository;
import com.jb.couponsys.repos.CouponRepository;
import com.jb.couponsys.repos.CustomerRepository;
import com.jb.couponsys.security.LoginResponse;
import com.jb.couponsys.security.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {

    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected TokenManager tokenManager;

    public abstract LoginResponse login(String email, String password) throws CouponSystemException;
}
