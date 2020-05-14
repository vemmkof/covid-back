package com.ipn.escom.covid.back.controller;

import com.ipn.escom.covid.back.controller.api.LogoutApi;
import com.ipn.escom.covid.back.service.ISessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class LogoutController implements LogoutApi {

    private final ISessionService sessionService;

    @Override
    public ResponseEntity<Boolean> logout(Principal principal) {
        return ResponseEntity.ok(sessionService.logout(principal.getName()));
    }
}
