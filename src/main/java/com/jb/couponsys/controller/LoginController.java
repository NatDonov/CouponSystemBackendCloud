package com.jb.couponsys.controller;

import com.jb.couponsys.clients.LoginManager;
import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.security.LoginRequest;
import com.jb.couponsys.security.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/login")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginController {

    private final LoginManager loginManager;


    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws CouponSystemException {
        return loginManager.login(loginRequest.getEmail(), loginRequest.getPassword(), loginRequest.getClientType());
    }



}
