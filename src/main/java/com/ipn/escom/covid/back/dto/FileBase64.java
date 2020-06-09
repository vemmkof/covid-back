package com.ipn.escom.covid.back.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class FileBase64 implements Serializable {
    private static final long serialVersionUID = -4017771072247040480L;
    private String fileName;
    private String base64;
}
