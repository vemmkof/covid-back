package com.ipn.escom.covid.back.entity.id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GrupoPorcentajeId implements Serializable {
    private static final long serialVersionUID = -2725171283275034619L;
    private Integer idGrupo;
    private Integer idPorcentaje;
}
