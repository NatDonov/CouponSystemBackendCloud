package com.jb.couponsys.clients;

import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.security.LoginResponse;
import com.jb.couponsys.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginManager {

    private  final AdminServiceImpl adminService;

    private final CompanyServiceImpl companyService;

    private final CustomerServiceImpl customerService;

    public LoginResponse login(String email, String password, ClientType clientType) throws CouponSystemException {

        LoginResponse loginResponse = null;

        switch (clientType) {
            case ADMINISTRATOR:
                loginResponse = adminService.login(email,password);
                break;
            case COMPANY:
                loginResponse = companyService.login(email,password);
                break;
            case CUSTOMER:
                loginResponse = customerService.login(email,password);
                break;
        }
        return loginResponse;
    }

}
