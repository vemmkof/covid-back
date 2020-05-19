package com.ipn.escom.covid.back.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "Grupo")
public class Grupo implements Serializable {
    private static final long serialVersionUID = -4252485677717048551L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrupo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUnidadAprendizaje", nullable = false)
    private UnidadAprendizaje unidadAprendizaje;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "noBoleta", nullable = false)
    private Alumno alumno;

    @Column(columnDefinition = "char(7)", nullable = false)
    private String secuencia;

    @Column(nullable = false)
    private Integer nivelSemestre;


}
