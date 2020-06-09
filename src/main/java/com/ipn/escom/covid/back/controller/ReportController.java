package com.ipn.escom.covid.back.controller;

import com.ipn.escom.covid.back.controller.api.ReportApi;
import com.ipn.escom.covid.back.dto.BajasDto;
import com.ipn.escom.covid.back.dto.FileBase64;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import com.ipn.escom.covid.back.service.IReportService;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class ReportController implements ReportApi {

    private final IReportService reportService;

    @ExceptionHandler({JRException.class})
    public ResponseEntity<Response<Object>> handleException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(Response.builder()
                .message(String.format("An error occurred: %s", ex.getMessage()))
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Response<FileBase64>> getReport(Principal principal) throws JRException {
        return ResponseEntity.ok(
                Response.<FileBase64>builder()
                        .entity(reportService.getReport(principal.getName()))
                        .message("Report was created.")
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response<UserDto>> saveReport(Principal principal, FileBase64 report) {
        return ResponseEntity.ok(
                Response.<UserDto>builder()
                        .entity(reportService.saveReport(principal.getName(), report))
                        .message("Report was saved.")
                        .build());
    }

    @Override
    public ResponseEntity<Response<FileBase64>> downloadReport(Principal principal, String fileName) {
        return ResponseEntity.ok(
                Response.<FileBase64>builder()
                        .entity(reportService.downloadReport(fileName))
                        .message("Report was found.")
                        .build());
    }

    @Override
    public ResponseEntity<Response<BajasDto>> getBajaReport(Principal principal) {
        return ResponseEntity.ok(
                Response.<BajasDto>builder()
                        .entity(reportService.getBajaReport())
                        .message("Bajas was found.")
                        .build());
    }
}
