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
@Table(name = "MedioComunicacion")
public class MedioComunicacion implements Serializable {

    private static final long serialVersionUID = -3912485676717048551L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedioComunicacion;

    @Column(nullable = false)
    private String nombreMedioComunicacion;
	
}
