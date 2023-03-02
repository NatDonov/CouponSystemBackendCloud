//package com.jb.couponsys.clr;
//
//import com.jb.couponsys.beans.Category;
//import com.jb.couponsys.beans.Company;
//import com.jb.couponsys.beans.Coupon;
//import com.jb.couponsys.clients.ClientType;
//import com.jb.couponsys.clients.LoginManager;
//import com.jb.couponsys.exceptions.CouponSystemException;
//import com.jb.couponsys.repos.CouponRepository;
//import com.jb.couponsys.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.List;
//
//@Component
//@Order(4)
//public class CustomerTest implements CommandLineRunner {
//
//    @Autowired
//    private LoginManager loginManager;
//
//    private CustomerService customerService = null;
//    @Autowired
//    private CouponRepository couponRepository;
//
//    @Override
//    public void run(String... args) {
//
//        System.out.print(Color.GREEN_BOLD);
//
//        System.out.println(" ██████╗██╗   ██╗███████╗████████╗ ██████╗ ███╗   ███╗███████╗██████╗     ████████╗███████╗███████╗████████╗███████╗\n" +
//                "██╔════╝██║   ██║██╔════╝╚══██╔══╝██╔═══██╗████╗ ████║██╔════╝██╔══██╗    ╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝██╔════╝\n" +
//                "██║     ██║   ██║███████╗   ██║   ██║   ██║██╔████╔██║█████╗  ██████╔╝       ██║   █████╗  ███████╗   ██║   ███████╗\n" +
//                "██║     ██║   ██║╚════██║   ██║   ██║   ██║██║╚██╔╝██║██╔══╝  ██╔══██╗       ██║   ██╔══╝  ╚════██║   ██║   ╚════██║\n" +
//                "╚██████╗╚██████╔╝███████║   ██║   ╚██████╔╝██║ ╚═╝ ██║███████╗██║  ██║       ██║   ███████╗███████║   ██║   ███████║\n" +
//                " ╚═════╝ ╚═════╝ ╚══════╝   ╚═╝    ╚═════╝ ╚═╝     ╚═╝╚══════╝╚═╝  ╚═╝       ╚═╝   ╚══════╝╚══════╝   ╚═╝   ╚══════╝\n" +
//                "                                                                                                                    ");
//        System.out.println(Color.RESET);
//
//
//        customerLogin();
//        System.out.println();
//        purchaseCoupon();
//        System.out.println();
//        getCustomerCoupons();
//        System.out.println();
//        getCustomerCouponsByCategory();
//        System.out.println();
//        getCustomerCouponsByMaxPrice();
//        System.out.println();
//        getCustomerDetails();
//        System.out.println();
//
//
//    }
//
//    public void getCustomerDetails() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET CUSTOMER DETAILS*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(customerService.getCustomerDetails(6));
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//    public void getCustomerCouponsByMaxPrice() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET CUSTOMER COUPONS BY MAX PRICE(200)*****************");
//        System.out.println(Color.RESET);
//
//        List<Coupon> couponList = customerService.getCustomerCouponByMaxPrice(6, 200);
//        for (Coupon coupon : couponList) {
//            System.out.println(coupon + "\n");
//        }
//    }
//
//    public void getCustomerCouponsByCategory() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET CUSTOMER COUPONS BY CATEGORY(ELECTRICITY)*****************");
//        System.out.println(Color.RESET);
//        try {
//            List<Coupon> couponList = customerService.getCustomerCouponByCategory(6, Category.ELECTRICITY);
//            for (Coupon coupon : couponList) {
//                System.out.println(coupon);
//            }
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//    public void getCustomerCoupons() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET CUSTOMER COUPONS*****************");
//        System.out.println(Color.RESET);
//        try {
//            List<Coupon> couponList = customerService.getCustomerCoupon(6);
//            for (Coupon coupon : couponList) {
//                System.out.println(coupon + "\n");
//            }
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//    public void purchaseCoupon() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************PURCHASE COUPON*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(">>>>Succeed purchase coupons<<<<");
//            Coupon coupon = customerService.getOneCoupon(6, 5);
//            customerService.purchaseCoupon(6, coupon);
//            Coupon coupon2 = customerService.getOneCoupon(6, 7);
//            customerService.purchaseCoupon(6, coupon2);
//            Coupon coupon3 = customerService.getOneCoupon(6, 11);
//            customerService.purchaseCoupon(6, coupon3);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed purchase coupon - expiry date has passed");
//
//            Coupon coupon = Coupon.builder().company(Company.builder().id(10).name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build()).category(Category.ELECTRICITY).title("Abc").description("Connect to internet and get a router free").startDate(Date.valueOf(LocalDate.now().minusMonths(2))).endDate(Date.valueOf(LocalDate.now().minusMonths(1))).amount(2).price(100).image("abc").build();
//            couponRepository.save(coupon);
//            customerService.purchaseCoupon(6, coupon);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed purchase coupon - coupons are out of stock");
//            Coupon coupon = customerService.getOneCoupon(6, 6);
//            customerService.purchaseCoupon(6, coupon);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed purchase coupon - Coupon already purchased");
//            Coupon coupon = customerService.getOneCoupon(6, 5);
//            customerService.purchaseCoupon(6, coupon);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//    public void customerLogin() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************CUSTOMER LOGIN*****************");
//        System.out.println(Color.RESET);
//
//        try {
//            System.out.println(">>>>Succeed login<<<<");
//            customerService = (CustomerService) loginManager.login("Moshe@gmail.com", "mosh567", ClientType.CUSTOMER);
//
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed login - email is wrong");
//            customerService = (CustomerService) loginManager.login("Bezeq@gmail.com", "mosh567", ClientType.CUSTOMER);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed login - password is wrong");
//            customerService = (CustomerService) loginManager.login("Simon@gmail.com", "bezeq1234", ClientType.CUSTOMER);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//}
//
