package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.OauthAccessToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OauthAccessTokenRepository extends CrudRepository<OauthAccessToken, String> {
    Optional<OauthAccessToken> findByUserName(String userName);
}
