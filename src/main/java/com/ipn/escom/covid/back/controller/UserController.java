package com.ipn.escom.covid.back.controller;

import com.ipn.escom.covid.back.controller.api.UserApi;
import com.ipn.escom.covid.back.dto.GroupsDto;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import com.ipn.escom.covid.back.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final IUserService userService;

    @Override
    public ResponseEntity<Response<UserDto>> getUser(Principal principal) {
        return ResponseEntity.ok(
                Response.<UserDto>builder()
                        .entity(userService.getUser(principal.getName()))
                        .message("User was found.")
                        .build());
    }

    @Override
    public ResponseEntity<Response<GroupsDto>> getUserGroups(Principal principal) {
        return ResponseEntity.ok(
                Response.<GroupsDto>builder()
                        .entity(userService.getUserGroups(principal.getName()))
                        .message("Groups was found.")
                        .build()
        );
    }
}
