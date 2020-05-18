package com.ipn.escom.covid.back.controller;

import com.ipn.escom.covid.back.controller.api.QuizApi;
import com.ipn.escom.covid.back.dto.MatrixRequest;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import com.ipn.escom.covid.back.service.IQuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class QuizController implements QuizApi {

    private final IQuizService quizService;

    @Override
    public ResponseEntity<Response<UserDto>> saveMatrix(Principal principal, MatrixRequest matrixRequest) {
        return ResponseEntity.ok(quizService.saveMatrix(principal.getName(), matrixRequest));
    }
}
