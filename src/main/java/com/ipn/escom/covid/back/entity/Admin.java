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
@Table(name = "Admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 3525747456420033354L;

    @Id
    @Column(columnDefinition = "char(11)")
    private String noBoleta;

    @Column(nullable = false)
    private String apellidoPaterno;

    @Column(nullable = false)
    private String apellidoMaterno;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String CURP;

    @Column(nullable = false, columnDefinition = "varchar(100) default 'sinemail@sinemail.com'")
    private String email;

}
