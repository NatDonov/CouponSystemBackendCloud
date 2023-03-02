//package com.jb.couponsys.clr;
//
//import com.jb.couponsys.beans.Category;
//import com.jb.couponsys.beans.Company;
//import com.jb.couponsys.beans.Coupon;
//import com.jb.couponsys.clients.ClientType;
//import com.jb.couponsys.clients.LoginManager;
//import com.jb.couponsys.exceptions.CouponSystemException;
//
//import com.jb.couponsys.service.CompanyService;
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
//@Order(3)
//public class CompanyTest implements CommandLineRunner {
//
//    private CompanyService companyService = null;
//    @Autowired
//    private LoginManager loginManager;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        System.out.print(Color.GREEN_BOLD);
//
//        System.out.println(" ██████╗ ██████╗ ███╗   ███╗██████╗  █████╗ ███╗   ██╗██╗   ██╗    ████████╗███████╗███████╗████████╗███████╗\n" +
//                "██╔════╝██╔═══██╗████╗ ████║██╔══██╗██╔══██╗████╗  ██║╚██╗ ██╔╝    ╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝██╔════╝\n" +
//                "██║     ██║   ██║██╔████╔██║██████╔╝███████║██╔██╗ ██║ ╚████╔╝        ██║   █████╗  ███████╗   ██║   ███████╗\n" +
//                "██║     ██║   ██║██║╚██╔╝██║██╔═══╝ ██╔══██║██║╚██╗██║  ╚██╔╝         ██║   ██╔══╝  ╚════██║   ██║   ╚════██║\n" +
//                "╚██████╗╚██████╔╝██║ ╚═╝ ██║██║     ██║  ██║██║ ╚████║   ██║          ██║   ███████╗███████║   ██║   ███████║\n" +
//                " ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝   ╚═╝          ╚═╝   ╚══════╝╚══════╝   ╚═╝   ╚══════╝\n" +
//                "                                                                                                             ");
//        System.out.println(Color.RESET);
//
//        companyLogin();
//        System.out.println();
//
//        addCoupon();
//        System.out.println();
//
//        updateCoupon();
//        System.out.println();
//
//        deleteCoupon();
//        System.out.println();
//
//        getCompanyCoupons();
//        System.out.println();
//
//        getCompanyCouponsByCategory();
//        System.out.println();
//
//        getCompanyCouponsByMaxPrice();
//        System.out.println();
//
//        getCompanyDetails();
//        System.out.println();
//
//    }
//
//    public void getCompanyDetails() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET COMPANY DETAILS*****************");
//        System.out.println(Color.RESET);
//        try {
//
//            System.out.println(companyService.getCompanyDetails(10));
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//
//    public void getCompanyCouponsByMaxPrice() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET COMPANY COUPONS BY MAX(100) PRICE*****************");
//        System.out.println(Color.RESET);
//
//        List<Coupon> couponList = companyService.getCompanyCouponsByMaxPrice(10, 100);
//
//        for (Coupon coupon : couponList) {
//            System.out.println(coupon + "\n");
//        }
//    }
//
//
//    public void getCompanyCouponsByCategory() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET COMPANY COUPONS BY CATEGORY(FOOD)*****************");
//        System.out.println(Color.RESET);
//
//        List<Coupon> couponList = companyService.getAllCompanyCouponsByCategory(10, Category.FOOD);
//
//        for (Coupon coupon : couponList) {
//            System.out.println(coupon + "\n");
//        }
//    }
//
//
//    public void getCompanyCoupons() throws CouponSystemException {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************GET COMPANY COUPONS*****************");
//        System.out.println(Color.RESET);
//
//        List<Coupon> couponList = companyService.getCompanyCoupons(10);
//
//        for (Coupon coupon : couponList) {
//            System.out.println(coupon + "\n");
//        }
//
//    }
//
//    public void deleteCoupon() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************DELETE COUPON*****************");
//        System.out.println(Color.RESET);
//
//        try {
//            System.out.println(">>>>Succeed to delete coupon>>>>");
//            companyService.deleteCoupon(10, 8);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println("Failed to delete coupon - not found coupon");
//            companyService.deleteCoupon(10, 20);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//    }
//
//    public void updateCoupon() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************UPDATE COUPON*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(Color.WHITE_BOLD);
//            Coupon coupon = companyService.getOneCoupon(10, 3);
//            System.out.println("Coupon before update: " + coupon);
//            System.out.println(Color.RESET);
//            System.out.println(">>>>Succeed update coupon<<<<");
//            Coupon couponToUpdate = companyService.getOneCoupon(10, 3);
//            couponToUpdate.setDescription("New description");
//            companyService.updateCoupon(10, 3, couponToUpdate);
//            System.out.println(Color.WHITE_BOLD);
//            System.out.println("Coupon after update: " + couponToUpdate);
//            System.out.println(Color.RESET);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed to update coupon - error coupon-id");
//            Coupon couponToUpdate = companyService.getOneCoupon(10, 10);
//            couponToUpdate.setId(5);
//            companyService.updateCoupon(10, 10, couponToUpdate);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//        try {
//            System.out.println("Failed to update coupon - error title");
//            Coupon couponToUpdate = companyService.getOneCoupon(10, 10);
//            couponToUpdate.setTitle("Router222");
//            companyService.updateCoupon(10, 10, couponToUpdate);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//    }
//
//    public void addCoupon() {
//
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************ADD COUPON*****************");
//        System.out.println(Color.RESET);
//        try {
//            System.out.println(">>>>Succeed add coupon<<<<");
//
//            Coupon coupon = Coupon.builder()
//                    .company(Company.builder().id(10).name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build())
//                    .category(Category.ELECTRICITY)
//                    .title("Big Sale - Laptop")
//                    .description("Bay a laptop, get a charger as a gift ")
//                    .startDate(Date.valueOf(LocalDate.now()))
//                    .endDate(Date.valueOf(LocalDate.now()
//                            .plusMonths(2)))
//                    .amount(5)
//                    .price(200)
//                    .image("image").build();
//
//
//            Coupon coupon1 = Coupon.builder()
//                    .company(Company.builder().id(10).name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build())
//                    .category(Category.FOOD)
//                    .title("1+1")
//                    .description("Buy two for the price of one")
//                    .startDate(Date.valueOf(LocalDate.now()
//                            .minusMonths(2)))
//                    .endDate(Date.valueOf(LocalDate.now()
//                            .plusMonths(1)))
//                    .amount(0)
//                    .price(20)
//                    .image(" image1").build();
//
//
//            Coupon coupon2 = Coupon.builder()
//                    .company(Company.builder().id(10).name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build()).category(Category.COURSES).title("Hottest sale").description(" Buy a course, get the best practitioner as a gift").startDate(Date.valueOf(LocalDate.now().minusMonths(5))).endDate(Date.valueOf(LocalDate.now().plusMonths(2))).amount(5).price(24_000).image("image2").build();
//
//
//            Coupon coupon3 = Coupon.builder().company(Company.builder().id(10).name("Bezeq")
//                    .email("Bezeq@gmail.com").password("bezeq1234").build()).category(Category.TOYS).title("Big sale on toys").description("Buy two, get free").startDate(Date.valueOf(LocalDate.now().minusMonths(5))).endDate(Date.valueOf(LocalDate.now().plusMonths(1))).amount(3).price(350).image("image3").build();
//
//
//            Coupon coupon4 = Coupon.builder().company(Company.builder().id(10).name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build()).category(Category.ELECTRICITY).title("Router").description("Connect to internet and get a router free").startDate(Date.valueOf(LocalDate.now().minusMonths(1))).endDate(Date.valueOf(LocalDate.now().plusMonths(2))).amount(2).price(100).image("router").build();
//            Coupon coupon5 = Coupon.builder().company(Company.builder().id(10).name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build()).category(Category.VACATION).title("Router222").description("Connect to internet and get a router free222").startDate(Date.valueOf(LocalDate.now().minusMonths(1))).endDate(Date.valueOf(LocalDate.now().plusMonths(2))).amount(2).price(200).image("router").build();
//            Coupon coupon6 = Coupon.builder().company(Company.builder().id(10).name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build()).category(Category.FOOD).title("Router333").description("Connect to internet and get a router free333").startDate(Date.valueOf(LocalDate.now().minusMonths(1))).endDate(Date.valueOf(LocalDate.now().plusMonths(2))).amount(2).price(100).image("router").build();
//
//
//            companyService.addCoupon(10, coupon);
//            companyService.addCoupon(10, coupon1);
//            companyService.addCoupon(10, coupon2);
//            companyService.addCoupon(10, coupon3);
//            companyService.addCoupon(10, coupon4);
//            companyService.addCoupon(10, coupon5);
//            companyService.addCoupon(10, coupon6);
//
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println("Failed add coupon - title error");
//
//            Coupon coupon1 = Coupon.builder().company(Company.builder().id(10).name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build()).category(Category.FOOD).title("1+1").description("Buy two for the price of one ").startDate(Date.valueOf(LocalDate.now().minusMonths(2))).endDate(Date.valueOf(LocalDate.now().plusMonths(1))).amount(2).price(20).image("          .!.!.                             \n" +
//                    "image").build();
//            companyService.addCoupon(10, coupon1);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println(">>>>Succeed add coupon - with title like other company's coupon<<<<");
//            Coupon coupon1 = Coupon.builder().company(Company.builder().id(10).name("Bezeq").email("Bezeq@gmail.com").password("bezeq1234").build()).category(Category.FOOD).title("title 3").description("Buy two for the price of one ").startDate(Date.valueOf(LocalDate.now().minusMonths(2))).endDate(Date.valueOf(LocalDate.now().plusMonths(1))).amount(2).price(20).image("          .!.!.                             \n" +
//                    "image").build();
//
//            companyService.addCoupon(10, coupon1);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//    }
//
//    public void companyLogin() {
//        System.out.print(Color.BLUE_BOLD);
//        System.out.println("*****************COMPANY LOGIN*****************");
//        System.out.println(Color.RESET);
//
//        try {
//            System.out.println(">>>>Succeed login<<<<");
//            companyService = (CompanyService) loginManager.login("Bezeq@gmail.com", "bezeq1234", ClientType.COMPANY);
//
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println("Failed login - password is wrong");
//            companyService = (CompanyService) loginManager.login("Bezeq@gmail.com", "bezeq567", ClientType.COMPANY);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//        try {
//            System.out.println("Failed login - email is wrong");
//            companyService = (CompanyService) loginManager.login("Mezeq@gmail.com", "bezeq1234", ClientType.COMPANY);
//        } catch (CouponSystemException couponSystemException) {
//            System.out.println(couponSystemException);
//        }
//
//    }
//
//}
