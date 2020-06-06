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
public class BajaId implements Serializable {
    private static final long serialVersionUID = 5679882610778748068L;
    private Integer idGrupo;
    private String noBoleta;

}
