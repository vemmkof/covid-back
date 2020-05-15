package com.ipn.escom.covid.back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Grupo_has_Porcentaje")
public class GrupoTienePorcentaje implements Serializable {
    private static final long serialVersionUID = -252629614060946428L;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Grupo_idGrupo", nullable = false)
    private Grupo grupo;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Porcentaje_idPorcentaje", nullable = false)
    private Porcentaje porcentaje;
}
