package com.jb.couponsys.thread;

import com.jb.couponsys.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Job {

    @Autowired
    private CouponRepository couponRepository;

    private final int TIME_TO_SLEEP = 1000 * 60 * 60 * 24;


    @Scheduled(fixedRate = TIME_TO_SLEEP, initialDelay = 1000 * 60)
    public void deleteCouponsExpired() {
        couponRepository.deleteExpiredPurchasedCoupons();
        couponRepository.deleteExpiredCoupons();
    }


}
