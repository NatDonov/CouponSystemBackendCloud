package com.jb.couponsys.security;

import com.jb.couponsys.clients.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {


    private String email;
    private String password;
    private ClientType clientType;


}
