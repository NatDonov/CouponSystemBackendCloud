package com.jb.couponsys.security;

import com.jb.couponsys.clients.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private UUID token;
    private int id;
    private String email;
    private String name;
    private ClientType clientType;
}
