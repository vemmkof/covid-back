package com.ipn.escom.covid.back.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto implements Serializable {
	private static final long serialVersionUID = 1342391977124731282L;
	private String fullName;
	private String noBoleta;
	private String email;
//	private List<BajaDto> bajaDtos;
}
