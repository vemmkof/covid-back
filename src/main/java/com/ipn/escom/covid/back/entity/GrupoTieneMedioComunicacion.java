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
@Table(name = "Grupo_has_MedioComunicacion")
public class GrupoTieneMedioComunicacion implements Serializable {
    private static final long serialVersionUID = -289084811060262663L;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Grupo_idGrupo", nullable = false)
    private Grupo grupo;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MedioComunicacion_idMedioComunicacion", nullable = false)
    private MedioComunicacion medioComunicacion;
}
