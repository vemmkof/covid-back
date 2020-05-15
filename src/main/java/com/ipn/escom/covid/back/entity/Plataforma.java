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
@Table(name = "Plataforma")
public class Plataforma implements Serializable {

	private static final long serialVersionUID = 6564986598702072374L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlataforma;

    @Column(nullable = false)
    private String nombrePlataforma;
}
