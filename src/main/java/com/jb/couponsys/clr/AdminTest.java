//package com.jb.couponsys.clr;
//
//import com.jb.couponsys.beans.Company;
//import com.jb.couponsys.beans.Customer;
//import com.jb.couponsys.clients.ClientType;
//import com.jb.couponsys.clients.LoginManager;
//import com.jb.couponsys.exceptions.CouponSystemException;
//import com.jb.couponsys.service.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
////@Component
//@Order(2)
//public class AdminTest implements CommandLineRunner {
//
//    private AdminService adminService = null;
//
//    @Autowired
//    private LoginManager loginManager;
//
//    @Override
//    public void run(String... args) {
//
//        System.out.print(Color.GREEN_BOLD);
//        System.out.println(" █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗    ████████╗███████╗███████╗████████╗███████╗\n" +
//                "██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║    ╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝██╔════╝\n" +
//                "███████║██║  ██║██╔████╔██║██║██╔██╗ ██║       ██║   █████╗  ███████╗   ██║   ███████╗\n" +
//                "██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║       ██║   ██╔══╝  ╚════██║   ██║   ╚════██║\n" +
//                "██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║       ██║   ███████╗███████║   ██║   ███████║\n" +
//                "╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝       ╚═╝   ╚══════╝╚══════╝   ╚═╝   ╚══════╝\n" +
//                "                                                                                      ");
//        System.out.println(Color.RESET);
//
//
//        adminLogin();
//        System.out.println();
//
//        addCompany();
//        System.out.println();
//
//
//        updateCompany();
//        System.out.println();
//
//
//        deleteCompany();
//        System.out.println();
//
//
//        getAllCompanies();
//        System.out.println();
//
//        getOneCompany();
//        System.out.println();
//
//        addCustomer();
//        System.out.println();
//
//        updateCustomer();
//        System.out.println();
//
//        deleteCustomer();
//        System.out.println();
//
//        getAllCustomers();
//        System.out.println();
//
//        getOneCustomer();
//        System.out.println();
//
//    }
//
//    public void getOneCustomer() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET ONE CUSTOMER*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(">>>>Succeed to get one customer<<<<");
//            System.out.println(adminService.getSingleCustomer(5));
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println("Failed to get one customer - customer not found");
//            adminService.getSingleCustomer(20);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//    public void getAllCustomers() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET ALL CUSTOMERS*****************");
//        System.out.println(Color.RESET);
//
//        System.out.println(">>>>Succeed to get all customers<<<<");
//        List<Customer> customerList = adminService.getAllCustomer();
//        for (Customer customer : customerList) {
//            System.out.println(customer);
//        }
//
//    }
//
//
//    public void deleteCustomer() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************DELETE CUSTOMER*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(">>>>Succeed delete customer<<<<");
//            Customer customerToDelete = adminService.getSingleCustomer(2);
//            adminService.deleteCustomer(customerToDelete.getId());
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed update customer - customer not found");
//            Customer customerToDelete = adminService.getSingleCustomer(20);
//            adminService.deleteCustomer(customerToDelete.getId());
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//    public void updateCustomer() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************UPDATE CUSTOMER*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(Color.WHITE_BOLD);
//            System.out.println("Customer before update: " + adminService.getSingleCustomer(1));
//            System.out.println(Color.RESET);
//            System.out.println(">>>>Succeed update customer>>>>");
//            Customer customerToUpdate = adminService.getSingleCustomer(1);
//            customerToUpdate.setFirstName("Guy");
//            customerToUpdate.setLastName("Wolfson");
//            customerToUpdate.setPassword("Guy1212");
//            adminService.updateCustomer(1, customerToUpdate);
//            System.out.println(Color.WHITE_BOLD);
//            System.out.println("Customer after update: " + customerToUpdate);
//            System.out.println(Color.RESET);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println("Failed to update customer - error email - the email is exists already");
//            Customer customerToUpdate = adminService.getSingleCustomer(1);
//            customerToUpdate.setFirstName("Guy");
//            customerToUpdate.setLastName("Wolfson");
//            customerToUpdate.setPassword("Guy1212");
//            customerToUpdate.setEmail("Adi@gmail.com");
//            adminService.updateCustomer(1, customerToUpdate);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed to update customer - not found customer");
//            Customer customerToUpdate = adminService.getSingleCustomer(10);
//            customerToUpdate.setFirstName("Liya");
//            customerToUpdate.setLastName("Ben Moshe");
//            adminService.updateCustomer(10, customerToUpdate);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed to update customer - error id");
//            Customer customerToUpdate = adminService.getSingleCustomer(2);
//            customerToUpdate.setFirstName("Marina");
//            adminService.updateCustomer(7, customerToUpdate);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//    public void addCustomer() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************ADD CUSTOMER*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(">>>>Succeed add customer>>>>");
//
//            Customer customer = Customer.builder().firstName("Natali").lastName("Donov").email("Natali@gmail.com").password("nat1234").build();
//            Customer customer1 = Customer.builder().firstName("Moshe").lastName("Levi").email("Moshe@gmail.com").password("mosh567").build();
//            Customer customer2 = Customer.builder().firstName("Adi").lastName("Halfon").email("Adi@gmail.com").password("adihal5566").build();
//            Customer customer3 = Customer.builder().firstName("Simon").lastName("Ganon").email("Simon@gmail.com").password("simon2233").build();
//            Customer customer4 = Customer.builder().firstName("Lea").lastName("Shriki").email("Lea@gmail.com").password("leashriki1").build();
//
//            adminService.addCustomer(customer);
//            adminService.addCustomer(customer1);
//            adminService.addCustomer(customer2);
//            adminService.addCustomer(customer3);
//            adminService.addCustomer(customer4);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed add customer");
//            Customer customer = Customer.builder().firstName("Viki").lastName("Kol").email("Natali@gmail.com").password("1234").build();
//            adminService.addCustomer(customer);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//    public void getOneCompany() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET ONE COMPANY*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(">>>>Succeed to get one company<<<<");
//            System.out.println(adminService.getSingleCompany(5));
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed to get one company - company not found");
//            adminService.getSingleCompany(20);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//    }
//
//    public void getAllCompanies() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET ALL COMPANIES*****************");
//        System.out.println(Color.RESET);
//        System.out.println(">>>>Succeed to get all companies<<<<");
//        List<Company> companyList = adminService.getAllCompany();
//        for (Company company : companyList) {
//            System.out.println(company);
//        }
//
//    }
//
//    public void deleteCompany() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************DELETE COMPANY*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(">>>>Succeed delete company<<<<");
//            Company companyToDelete = adminService.getSingleCompany(2);
//            adminService.deleteCompany(companyToDelete.getId());
//            Company companyToDelete1 = adminService.getSingleCompany(1);
//            adminService.deleteCompany(companyToDelete1.getId());
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed delete company - company not found");
//            Company companyToDelete = adminService.getSingleCompany(20);
//            adminService.deleteCompany(companyToDelete.getId());
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//    }
//
//    public void updateCompany() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************UPDATE COMPANY*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(Color.WHITE_BOLD);
//            System.out.println("Company before update: " + adminService.getSingleCompany(1));
//            System.out.println(Color.RESET);
//            System.out.println(">>>>Succeed update company<<<<");
//            Company companyToUpdate = adminService.getSingleCompany(1);
//            companyToUpdate.setEmail("Amazon2@gmail.com");
//            companyToUpdate.setPassword("4567");
//            adminService.updateCompany(1, companyToUpdate);
//            System.out.println(Color.WHITE_BOLD);
//            System.out.println("Company after update: " + companyToUpdate);
//            System.out.println(Color.RESET);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed update company - error not found");
//            Company companyToUpdate = adminService.getSingleCompany(20);
//            companyToUpdate.setEmail("Amazon2@gmail.com");
//            companyToUpdate.setPassword("4567");
//            adminService.updateCompany(2, companyToUpdate);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed update company - error id");
//            Company companyToUpdate = adminService.getSingleCompany(1);
//            adminService.updateCompany(5, companyToUpdate);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed update company - error name");
//            Company companyToUpdate = adminService.getSingleCompany(1);
//            companyToUpdate.setEmail("Amazon2@gmail.com");
//            companyToUpdate.setPassword("4567");
//            companyToUpdate.setName("Toto");
//            adminService.updateCompany(1, companyToUpdate);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println("Failed update company - error email - the email is exists already");
//            Company companyToUpdate = adminService.getSingleCompany(1);
//            companyToUpdate.setEmail("Rami@gmail.com");
//            companyToUpdate.setPassword("4567");
//            adminService.updateCompany(1, companyToUpdate);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//
//    }
//
//    public void addCompany() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************ADD COMPANY*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(">>>>Succeed add company<<<<");
//
//            Company company = Company.builder().name("Amazon").email("Amazon@gmail.com").password("1234").build();
//            Company company2 = Company.builder().name("Coca-Cola").email("Cola@gmail.com").password("5678").build();
//            Company company3 = Company.builder().name("RamiLevi").email("Rami@gmail.com").password("rami123").build();
//            Company company4 = Company.builder().name("Elite").email("Elite@gmail.com").password("elitbig").build();
//            Company company5 = Company.builder().name("Nespresso").email("Nespres@gmail.com").password("netggg").build();
//            Company company6 = Company.builder().name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build();
//            Company company7 = Company.builder().name("John Bryce").email("Johnbryce@gmail.com").password("john666").build();
//
//
//            adminService.addCompany(company);
//            adminService.addCompany(company2);
//            adminService.addCompany(company3);
//            adminService.addCompany(company4);
//            adminService.addCompany(company5);
//            adminService.addCompany(company6);
//            adminService.addCompany(company7);
//
//
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed add company - email error");
//            Company company = Company.builder().name("eBay").email("amazon@gmail.com").password("1234").build();
//            adminService.addCompany(company);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println("Failed add company - name error");
//            Company company = Company.builder().name("amazon").email("ebay@gmail.com").password("1234").build();
//            adminService.addCompany(company);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//    }
//
//
//    public void adminLogin() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************ADMIN LOGIN*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(">>>>Succeed login<<<<");
//            adminService = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println("Failed login - email is wrong");
//            adminService = (AdminService) loginManager.login("admin@tuyiu.com", "rtruy", ClientType.ADMINISTRATOR);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//}
//
