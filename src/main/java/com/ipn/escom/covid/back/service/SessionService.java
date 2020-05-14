package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.entity.OauthAccessToken;
import com.ipn.escom.covid.back.repository.OauthAccessTokenRepository;
import com.ipn.escom.covid.back.repository.OauthRefreshTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SessionService implements ISessionService {

    private final OauthAccessTokenRepository oauthAccessTokenRepository;
    private final OauthRefreshTokenRepository oauthRefreshTokenRepository;

    @Override
    public boolean logout(String username) {
        Optional<OauthAccessToken> accessToken = oauthAccessTokenRepository.findByUserName(username);
        if (accessToken.isPresent()) {
            String refreshToken = accessToken.get().getRefreshToken();
            oauthRefreshTokenRepository.deleteById(refreshToken);
            oauthAccessTokenRepository.delete(accessToken.get());
            return true;
        } else return false;
    }
}
