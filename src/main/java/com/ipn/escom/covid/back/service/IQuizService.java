package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.dto.MatrixRequest;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;

public interface IQuizService {
    Response<UserDto> saveMatrix(String plate, MatrixRequest matrixRequest);
}
