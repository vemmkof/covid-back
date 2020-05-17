package com.ipn.escom.covid.back.controller.api;

import com.ipn.escom.covid.back.dto.GroupsDto;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

public interface UserApi {
    @GetMapping("/user")
    ResponseEntity<Response<UserDto>> getUser(@Validated Principal principal);


    @GetMapping("/user/group")
    ResponseEntity<Response<GroupsDto>> getUserGroups(@Validated Principal principal);

}
