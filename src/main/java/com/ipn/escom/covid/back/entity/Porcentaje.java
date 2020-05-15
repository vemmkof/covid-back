package com.ipn.escom.covid.back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Porcentaje")
public class Porcentaje implements Serializable {

	private static final long serialVersionUID = 5563599812302017444L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPorcentaje;

    @Column(nullable = false)
    private String cantidad;
	
}
