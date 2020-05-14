package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.OauthAccessToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthAccessTokenRespository extends CrudRepository<OauthAccessToken, String> {
}
