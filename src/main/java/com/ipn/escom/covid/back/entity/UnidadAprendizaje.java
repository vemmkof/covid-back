package com.ipn.escom.covid.back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "UnidadAprendizaje")
public class UnidadAprendizaje implements Serializable {

    private static final long serialVersionUID = 8963811598724056489L;

    @Id
    private String idUnidadAprendizaje;

    @Column(nullable = false)
    private String nombreUnidadAprendizaje;
}
