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
public class GrupoPlataformaId implements Serializable {
    private static final long serialVersionUID = 3237646821730698922L;
    private Integer idGrupo;
    private Integer idPlataforma;
}
