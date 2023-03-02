package com.jb.couponsys.service;


import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.clients.ClientType;
import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.exceptions.ErrorMsg;
import com.jb.couponsys.security.Information;
import com.jb.couponsys.security.LoginResponse;
import com.jb.couponsys.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl extends ClientService implements AdminService {


    private void isAdmin(UUID token) throws CouponSystemException {
        tokenManager.isAuthorize(token, ClientType.ADMINISTRATOR);
    }

    @Override
    public LoginResponse login(String email, String password) throws CouponSystemException {
        if (!(email.equals("admin@admin.com") && password.equals("admin"))) {
            throw new CouponSystemException(ErrorMsg.ADMIN_LOGIN_ERROR);
        }
        Information information = Information.builder().id(-1).email("admin@admin.com").clientType(ClientType.ADMINISTRATOR).expirationTime(LocalDateTime.now().plusHours(1)).build();
        UUID token = tokenManager.addToken(information);
        return LoginResponse.builder().email("admin@admin.com").name("Admin").token(token).clientType(ClientType.ADMINISTRATOR).id(-1).build();
    }

    @Override
    public void addCompany(UUID token,Company company) throws CouponSystemException {
        isAdmin(token);
        if (companyRepository.existsById(company.getId())) {
            throw new CouponSystemException(ErrorMsg.COMPANY_EXIST);
        }
        if (companyRepository.existsByName(company.getName())) {
            throw new CouponSystemException(ErrorMsg.COMPANY_NAME_EXIST);
        }
        if (companyRepository.existsByEmail(company.getEmail())) {
            throw new CouponSystemException(ErrorMsg.COMPANY_EMAIL_EXIST);
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(UUID token, int companyId, Company company) throws CouponSystemException {
        isAdmin(token);
        Company companyFromDb = companyRepository.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMsg.COMPANY_EXIST));

        if (companyId != company.getId()) {
            throw new CouponSystemException(ErrorMsg.COMPANY_UPDATE_ID);
        }
        if (!(companyFromDb.getName().equals(company.getName()))) {
            throw new CouponSystemException(ErrorMsg.COMPANY_UPDATE_NAME);
        }
        if (companyRepository.existsByEmailAndIdNot(company.getEmail(), companyId)) {
            throw new CouponSystemException(ErrorMsg.COMPANY_EMAIL_EXIST);
        }

        companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(UUID token,int companyId) throws CouponSystemException {
        isAdmin(token);
        if (!companyRepository.existsById(companyId)) {
            throw new CouponSystemException(ErrorMsg.NOT_EXIST_COMPANY);
        }
        for (Coupon coupon : couponRepository.findByCompanyId(companyId)) {
            couponRepository.deletePurchaseCoupon(coupon.getId());
        }
        couponRepository.deletePurchaseCouponByCompanyId(companyId);
        companyRepository.deleteById(companyId);
    }


    @Override
    public List<Company> getAllCompany(UUID token) throws CouponSystemException {
        isAdmin(token);
        return companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(UUID token,int companyId) throws CouponSystemException {
        isAdmin(token);
        return companyRepository.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMsg.NOT_EXIST_COMPANY));
    }

    @Override
    public void addCustomer(UUID token,Customer customer) throws CouponSystemException {
        isAdmin(token);
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new CouponSystemException(ErrorMsg.CUSTOMER_EMAIL_EXIST);
        }
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(UUID token,int customerId, Customer customer) throws CouponSystemException {
        isAdmin(token);
        Customer customerFromBd = customerRepository.findById(customerId).orElseThrow(() -> new CouponSystemException(ErrorMsg.NOT_EXIST_CUSTOMER));
        if (customerId != customer.getId()) {
            throw new CouponSystemException(ErrorMsg.CUSTOMER_UPDATE_ID);
        }
        if (customerRepository.existsByEmailAndIdNot(customer.getEmail(), customerId)) {
            throw new CouponSystemException(ErrorMsg.CUSTOMER_EXIST);
        }

        customerRepository.saveAndFlush(customer);

    }

    @Override
    public void deleteCustomer(UUID token,int customerId) throws CouponSystemException {
        isAdmin(token);
        if (!customerRepository.existsById(customerId)) {
            throw new CouponSystemException(ErrorMsg.NOT_EXIST_CUSTOMER);
        }
        couponRepository.deletePurchaseCouponByCustomerId(customerId);
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomer(UUID token) throws CouponSystemException {
        isAdmin(token);
        return customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(UUID token, int customerId) throws CouponSystemException {
        isAdmin(token);
        return customerRepository.findById(customerId).orElseThrow(() -> new CouponSystemException(ErrorMsg.NOT_EXIST_CUSTOMER));
    }

}
