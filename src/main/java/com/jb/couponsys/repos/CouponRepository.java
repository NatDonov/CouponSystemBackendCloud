package com.jb.couponsys.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {

  @Transactional
  @Modifying
  @Query(value = "delete from customers_coupons where customers_coupons.coupons_id = ?", nativeQuery = true)
  void deletePurchaseCoupon(int couponId);

  @Transactional
  @Modifying
  @Query(value = "delete from customers_coupons where customers_coupons.customer_id = ?", nativeQuery = true)
  void deletePurchaseCouponByCustomerId(int customerId);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM coupons WHERE company_id = ?", nativeQuery = true)
  void deletePurchaseCouponByCompanyId(int companyId);

  boolean existsByTitleAndCompanyId(String title, int companyId);

  Optional<Coupon> findByIdAndCompanyId(int couponId, int companyId);

  List<Coupon> findByCompanyId(int companyId);

  @Query(value = "SELECT * FROM coupons inner join customers_coupons on coupons_id = id where customer_id = ?;", nativeQuery = true)
  List<Coupon> findCustomerPurchaseCoupons(int customerId);

  List<Coupon> findByCompanyIdAndCategory(int companyId, Category category);

  @Query(value = "select * from coupons where category = ? and id in (select coupons_id from customers_coupons where customer_id = ?)", nativeQuery = true)
  List<Coupon> findCustomerCouponsByCategory(String category, int customerId);

  List<Coupon> findByCompanyIdAndPriceLessThanEqual(int companyId, double maxPrice);

  @Query(value = "SELECT * FROM coupons inner join customers_coupons on coupons_id = id where customer_id = ? and price <= ?", nativeQuery = true)
  List<Coupon> findCustomerCouponsPriceLessThan(int customerId, double maxPrice);

  @Query(value = "SELECT EXISTS ( SELECT * FROM customers_coupons  WHERE (customer_id = ?) and (coupons_id = ?)) as res", nativeQuery = true)
  int existsByCustomerIdAndCouponId(int customerId, int couponId);

  @Transactional
  @Modifying
  @Query(value = "INSERT INTO customers_coupons (customer_id, coupons_id) VALUES (?, ?)", nativeQuery = true)
  void addPurchasedCoupon(int customerId, int couponId);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM customers_coupons WHERE coupons_id IN (SELECT id FROM coupons WHERE end_date < CURDATE()) ", nativeQuery = true)
  void deleteExpiredPurchasedCoupons();

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM coupons WHERE end_date < CURDATE()", nativeQuery = true)
  void deleteExpiredCoupons();

}
