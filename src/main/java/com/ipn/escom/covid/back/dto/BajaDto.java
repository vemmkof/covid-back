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
public class BajaDto implements Serializable {
	private static final long serialVersionUID = 2909848052353675933L;
	private String materia;
	private String grupo;
	private String motivo;
}
