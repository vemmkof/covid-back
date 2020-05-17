package com.ipn.escom.covid.back.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDto implements Serializable {
    private static final long serialVersionUID = 511555858478784921L;
    private String plate;
    private String fullName;
    private String email;
}
