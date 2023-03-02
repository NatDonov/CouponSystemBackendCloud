package com.jb.couponsys.security;

import com.jb.couponsys.clients.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Information {


    private int id;
    private String email;
    private LocalDateTime expirationTime;
    private ClientType clientType;


}
