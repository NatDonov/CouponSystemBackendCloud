package com.jb.couponsys.service;

import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.exceptions.CouponSystemException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AdminService {

    void addCompany(UUID token, Company company) throws CouponSystemException;

    void updateCompany(UUID token,int companyId, Company company) throws CouponSystemException;

    void deleteCompany(UUID token,int CompanyId) throws CouponSystemException;

    List<Company> getAllCompany(UUID token) throws CouponSystemException;

    Company getSingleCompany(UUID token,int companyId) throws CouponSystemException;

    void addCustomer(UUID token,Customer customer) throws CouponSystemException;

    void updateCustomer(UUID token,int customerId, Customer customer) throws CouponSystemException;

    void deleteCustomer(UUID token,int customerId) throws CouponSystemException;

    List<Customer> getAllCustomer(UUID token) throws CouponSystemException;

    Customer getSingleCustomer(UUID token,int customerId) throws CouponSystemException;
}
