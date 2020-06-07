package com.ipn.escom.covid.back.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.escom.covid.back.controller.api.UserApi;
import com.ipn.escom.covid.back.dto.GroupsDto;
import com.ipn.escom.covid.back.dto.ReportDto;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import com.ipn.escom.covid.back.service.IUserService;

import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

	private final IUserService userService;

	@Override
	public ResponseEntity<Response<UserDto>> getUser(Principal principal) {
		this.method();
		return ResponseEntity.ok(Response.<UserDto>builder().entity(userService.getUser(principal.getName()))
				.message("User was found.").build());
	}

	@Override
	public ResponseEntity<Response<GroupsDto>> getUserGroups(Principal principal) {
		return ResponseEntity.ok(Response.<GroupsDto>builder().entity(userService.getUserGroups(principal.getName()))
				.message("Groups was found.").build());
	}

	private void method() {
//		InputStream employeeReportStream = (InputStream) getClass().getResourceAsStream("/jasper/Comprobante.jrxml");
		try {
//			JasperDesign jasperDesign = JRXmlLoader.load("jasper/Comprobante.jrxml");
			JasperReport jasperReport = JasperCompileManager
					.compileReport(this.getClass().getResourceAsStream("/jasper/Comprobante.jrxml"));
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("report",
					ReportDto.builder().fullName("fullName123").noBoleta("noBoleta456").email("email789").build());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("employeeReport.pdf"));
			SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);

			SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
			exportConfig.setMetadataAuthor("vemm");
			exportConfig.setEncrypted(true);
			exportConfig.setAllowedPermissionsHint("PRINTING");

			exporter.setConfiguration(reportConfig);
			exporter.setConfiguration(exportConfig);

			exporter.exportReport();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
