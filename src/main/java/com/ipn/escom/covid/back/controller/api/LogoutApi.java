package com.ipn.escom.covid.back.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.security.Principal;

public interface LogoutApi {
    @DeleteMapping("/oauth/logout")
    ResponseEntity<Boolean> logout(@Validated Principal principal);
}

