package com.ipn.escom.covid.back.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer implements Serializable {
    private static final long serialVersionUID = 4288434983783683076L;
    private Integer idGrupo;
    private boolean baja;
    private String motivo;
//    private Integer idPlataforma;
//    private List<Integer> idsMedioComunicacion;
//    private Integer idPorcentaje;
}
