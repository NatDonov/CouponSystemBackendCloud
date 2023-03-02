package com.jb.couponsys.clr;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.repos.CompanyRepository;
import com.jb.couponsys.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {


        Coupon c1 = Coupon.builder().
                amount(4).
                category(Category.FOOD).
                description("1+1").
                title("Hamburger").
                price(150).
                startDate(Date.valueOf(LocalDate.now().minusMonths(2))).
                endDate(Date.valueOf(LocalDate.now().plusMonths(2))).
                image("https://picsum.photos/200/100?1").
                build();

        Coupon c2 = Coupon.builder().
                amount(4).
                category(Category.ELECTRICITY).
                description("Buy a TV get a LT as a gift").
                title("Laptop free").
                price(350).
                startDate(Date.valueOf(LocalDate.now())).
                endDate(Date.valueOf(LocalDate.now().plusMonths(4))).
                image("https://picsum.photos/200/100?2").
                build();

        Coupon c3 = Coupon.builder().
                amount(2).
                category(Category.FOOD).
                description("3 units for 50 NIS").
                title("Chocolate").
                price(30).
                startDate(Date.valueOf(LocalDate.now().minusMonths(2))).
                endDate(Date.valueOf(LocalDate.now().minusMonths(1))).
                image("https://picsum.photos/200/100?3").
                build();

        Coupon c4 = Coupon.builder().
                amount(6).
                category(Category.COURSES).
                description("Buy now").
                title("Course Full Stack Java").
                price(300).
                startDate(Date.valueOf(LocalDate.now())).
                endDate(Date.valueOf(LocalDate.now().plusMonths(1))).
                image("https://picsum.photos/200/100?4").
                build();


        Company cm1 = Company.builder().
                name("Mcdonald's").
                email("Mac1@gmail.com").
                password("1111").
                coupon(c1).build();

        Company cm2 = Company.builder().
                name("Samsung").
                email("Samsung2@gmail.com").
                password("2222").
                coupon(c2).build();

        Company cm3 = Company.builder().
                name("Elite").
                email("Elite3@gmail.com").
                password("3333").
                coupon(c3).build();

        Company cm4 = Company.builder().
                name("John Bryce").
                email("JohnBryce4@gmail.com").
                password("4444").
                coupon(c4).build();

        c1.setCompany(cm1);
        c2.setCompany(cm2);
        c3.setCompany(cm3);
        c4.setCompany(cm4);

        Customer cs1 = Customer.builder().
                firstName("Natatali").
                lastName("Donov").
                email("Nat1@gmail.com").
                password("111").
                coupons(List.of(c1,c3)).
                build();

        Customer cs2 = Customer.builder().
                firstName("Moshe").
                lastName("Choen").
                email("Moshe2@gmail.com").
                password("222").
                build();

        Customer cs3 = Customer.builder().
                firstName("Max").
                lastName("Lee").
                email("Max3@gmail.com").
                password("333").
                coupons(List.of(c2,c3)).
                build();

        Customer cs4 = Customer.builder().
                firstName("Lili").
                lastName("Brik").
                email("Lili4@gmail.com").
                password("444").
                build();


        companyRepository.saveAll(List.of(cm1,cm2,cm3,cm4));

        customerRepository.saveAll(List.of(cs1,cs2,cs3,cs4));


    }
}
