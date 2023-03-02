package com.jb.couponsys.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrDetails {
    private final String key = "Coupon System";
    private String value;
}
