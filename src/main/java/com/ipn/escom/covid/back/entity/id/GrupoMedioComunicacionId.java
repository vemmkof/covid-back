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
public class GrupoMedioComunicacionId implements Serializable {
    private static final long serialVersionUID = 9199176245265627537L;
    private Integer idGrupo;
    private Integer idMedioComunicacion;
}
