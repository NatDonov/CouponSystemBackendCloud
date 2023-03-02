package com.jb.couponsys.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.clients.ClientType;
import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.exceptions.ErrorMsg;
import com.jb.couponsys.security.Information;
import com.jb.couponsys.security.LoginResponse;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl extends ClientService implements CompanyService {



    @Override
    public LoginResponse login(String email, String password) throws CouponSystemException {
        Company companyFromDb = companyRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new CouponSystemException(ErrorMsg.COMPANY_EMAIL_OR_PASSWORD));
        Information information = Information.builder().id(companyFromDb.getId()).email(email).clientType(ClientType.COMPANY).expirationTime(LocalDateTime.now().plusHours(1)).build();
        UUID token = tokenManager.addToken(information);
        return LoginResponse.builder().email(email).name(companyFromDb.getName()).token(token).clientType(ClientType.COMPANY).id(companyFromDb.getId()).build();
    }

    @Override
    public void deleteCoupon(UUID token, int couponId) throws CouponSystemException {
        tokenManager.getCompanyId(token);
        if (!(couponRepository.existsById(couponId))) {
            throw new CouponSystemException(ErrorMsg.NOT_EXIST_COUPON);
        }
        couponRepository.deletePurchaseCoupon(couponId);
        couponRepository.deleteById(couponId);
    }

    @Override
    public void addCoupon(UUID token, Coupon coupon) throws CouponSystemException {
      int companyId = tokenManager.getCompanyId(token);
        if (couponRepository.existsByTitleAndCompanyId(coupon.getTitle(), companyId)) {
            throw new CouponSystemException(ErrorMsg.COUPON_TITLE_EXIST);
        }
        Company c = companyRepository.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMsg.NOT_EXIST_COMPANY));
        coupon.setCompany(c);
        couponRepository.save(coupon);
    }


    @Override
    public void updateCoupon(UUID token, int couponId, Coupon coupon) throws CouponSystemException {
        int companyId = tokenManager.getCompanyId(token);
        Company companyFromDB = companyRepository.findById(companyId)
                .orElseThrow(() -> new CouponSystemException(ErrorMsg.NOT_EXIST_COMPANY));
        if (!this.couponRepository.existsById(couponId)) {
            throw new CouponSystemException(ErrorMsg.NOT_EXIST_COUPON);
        }
        if (couponId != coupon.getId()) {
            throw new CouponSystemException(ErrorMsg.COUPON_UPDATE_ID);
        }
        if (couponRepository.existsByTitleAndCompanyId(coupon.getTitle(), companyId)) {
            throw new CouponSystemException(ErrorMsg.INVALID_COUPON_UPDATE);
        }
        coupon.setCompany(companyFromDB);
        coupon.setId(couponId);
        couponRepository.saveAndFlush(coupon);
    }


    @Override
    public List<Coupon> getCompanyCoupons(UUID token) throws CouponSystemException {
        int companyId = tokenManager.getCompanyId(token);
        return couponRepository.findByCompanyId(companyId);
    }


    @Override
    public List<Coupon> getAllCompanyCouponsByCategory(UUID token, Category category) throws CouponSystemException {
      int companyId = tokenManager.getCompanyId(token);
        return couponRepository.findByCompanyIdAndCategory(companyId, category);
    }

    @Override
    public List<Coupon> getCompanyCouponsByMaxPrice(UUID token, double maxPrice) throws CouponSystemException {
      int companyId = tokenManager.getCompanyId(token);
        return couponRepository.findByCompanyIdAndPriceLessThanEqual(companyId, maxPrice);
    }

    @Override
    public Company getCompanyDetails(UUID token) throws CouponSystemException {
      int companyId = tokenManager.getCompanyId(token);
        List<Coupon> coupons = couponRepository.findByCompanyId(companyId);
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMsg.NOT_EXIST_COMPANY));
        company.setCoupons(coupons);
        return company;
    }

    @Override
    public Coupon getOneCoupon(UUID token, int couponId) throws CouponSystemException {
      int companyId = tokenManager.getCompanyId(token);
        return couponRepository.findByIdAndCompanyId(couponId, companyId).orElseThrow(() -> new CouponSystemException(ErrorMsg.NOT_EXIST_COUPON));
    }


}
