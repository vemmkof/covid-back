package com.ipn.escom.covid.back.controller.api;

import com.ipn.escom.covid.back.dto.MatrixRequest;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

public interface QuizApi {

    @PostMapping("/quiz")
    ResponseEntity<Response<UserDto>> saveMatrix(@Validated Principal principal, @RequestBody MatrixRequest matrixRequest);

}
