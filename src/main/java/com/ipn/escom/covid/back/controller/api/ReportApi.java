package com.ipn.escom.covid.back.controller.api;

import com.ipn.escom.covid.back.dto.BajasDto;
import com.ipn.escom.covid.back.dto.FileBase64;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

public interface ReportApi {
    @GetMapping("/report")
    ResponseEntity<Response<FileBase64>> getReport(@Validated Principal principal) throws JRException;

    @PostMapping("/report")
    ResponseEntity<Response<UserDto>> saveReport(@Validated Principal principal, @RequestBody FileBase64 report);

    @GetMapping("/report/download")
    ResponseEntity<Response<FileBase64>> downloadReport(@Validated Principal principal, @RequestParam String fileName);

    @GetMapping("/report/baja")
    ResponseEntity<Response<BajasDto>> getBajaReport(@Validated Principal principal);
}
