package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.OauthRefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthRefreshTokenRepository extends CrudRepository<OauthRefreshToken, String> {
}
