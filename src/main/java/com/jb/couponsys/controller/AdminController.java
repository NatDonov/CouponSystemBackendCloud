package com.jb.couponsys.controller;

import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/admin/")

@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("companies")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestHeader("Authorization") UUID token, @RequestBody Company company) throws CouponSystemException {
        adminService.addCompany(token, company);
    }


    @DeleteMapping("companies/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@RequestHeader("Authorization") UUID token,@PathVariable int companyId) throws CouponSystemException {
        adminService.deleteCompany(token,companyId);
    }


    @PutMapping("companies/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@RequestHeader("Authorization") UUID token,@PathVariable int companyId, @RequestBody Company company) throws CouponSystemException {
        adminService.updateCompany(token,companyId, company);
    }


    @GetMapping("companies")
    public List<Company> getAllCompanies(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        return adminService.getAllCompany(token);
    }


    @GetMapping("companies/{companyId}")
    public Company getOneCompany(@RequestHeader("Authorization") UUID token,@PathVariable int companyId) throws CouponSystemException {
        return adminService.getSingleCompany(token,companyId);
    }


    @PostMapping("customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestHeader("Authorization") UUID token,@RequestBody Customer customer) throws CouponSystemException {
        adminService.addCustomer(token,customer);
    }


    @DeleteMapping("customers/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@RequestHeader("Authorization") UUID token,@PathVariable int customerId) throws CouponSystemException {
        adminService.deleteCustomer(token,customerId);
    }

    @PutMapping("customers/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestHeader("Authorization") UUID token,@PathVariable int customerId, @RequestBody Customer customer) throws CouponSystemException {
        adminService.updateCustomer(token,customerId, customer);
    }

    @GetMapping("customers")
    public List<Customer> getAllCustomers(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        return adminService.getAllCustomer(token);
    }

    @GetMapping("customers/{customerId}")
    public Customer getOneCustomer(@RequestHeader("Authorization") UUID token,@PathVariable int customerId) throws CouponSystemException {
        return adminService.getSingleCustomer(token,customerId);
    }


}
