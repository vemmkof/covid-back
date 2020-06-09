package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.dto.BajasDto;
import com.ipn.escom.covid.back.dto.FileBase64;
import com.ipn.escom.covid.back.dto.UserDto;
import net.sf.jasperreports.engine.JRException;

public interface IReportService {

    FileBase64 getReport(String name) throws JRException;

    UserDto saveReport(String name, FileBase64 report);

    FileBase64 downloadReport(String fileName);

    BajasDto getBajaReport();
}
