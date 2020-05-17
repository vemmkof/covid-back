package com.ipn.escom.covid.back.dto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 4683562691115051217L;
    private final Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private T entity;
    private String message;

}
