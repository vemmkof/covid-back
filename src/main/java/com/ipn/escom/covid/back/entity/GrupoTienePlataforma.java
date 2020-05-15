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
@Table(name = "Grupo_has_Plataforma")
public class GrupoTienePlataforma implements Serializable {
    private static final long serialVersionUID = -2637485677351748551L;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Grupo_idGrupo", nullable = false)
    private Grupo grupo;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Plataforma_idPlataforma", nullable = false)
    private Plataforma plataforma;
}
