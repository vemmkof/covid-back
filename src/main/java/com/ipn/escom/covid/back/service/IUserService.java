package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.dto.UserDto;

public interface IUserService {
    UserDto getUser(String plate);
}
