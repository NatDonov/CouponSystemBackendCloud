package com.jb.couponsys.security;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jb.couponsys.clients.ClientType;
import com.jb.couponsys.exceptions.CouponSystemException;
import com.jb.couponsys.exceptions.ErrorMsg;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenManager {

    private final Map<UUID, Information> tokens;


    public UUID addToken(Information information) {
        deleteToken(information.getId());
        UUID token = UUID.randomUUID();
        while (tokens.containsKey(token)) {
            token = UUID.randomUUID();
        }
        tokens.put(token, information);
        return token;
    }

    private void deleteToken(int id) {
        tokens.entrySet().removeIf((token) -> token.getValue().getId() == id);
    }


    private int getUserId(UUID token, ClientType clientType) throws CouponSystemException {
        checkToken(token, clientType);
        return tokens.get(token).getId();
    }


    private void checkToken(UUID token, ClientType clientType) throws CouponSystemException {
        Information information = tokens.get(token);
        if (information == null) {
            throw new CouponSystemException(ErrorMsg.TOKEN_NOT_VALID);
        }
        if (information.getClientType() != clientType) {
            throw new CouponSystemException(ErrorMsg.UNAUTHORIZED_ACTION);
        }
    }

    public int getCustomerId(UUID token) throws CouponSystemException {
        return getUserId(token, ClientType.CUSTOMER);
    }

    public int getCompanyId(UUID token) throws CouponSystemException {
        return getUserId(token, ClientType.COMPANY);
    }

    @Scheduled(fixedRate = 1000*60)
    public void deleteExpiredTokens(){
        tokens.entrySet().removeIf((token)->token.getValue().getExpirationTime().isBefore(LocalDateTime.now()));
    }

    public boolean isAuthorize(UUID token, ClientType clientType) throws CouponSystemException {
        checkToken(token, clientType);
        return true;
    }





}
