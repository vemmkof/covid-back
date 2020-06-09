package com.ipn.escom.covid.back.entity;

import com.ipn.escom.covid.back.entity.id.BajaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Baja")
public class Baja implements Serializable {

    private static final long serialVersionUID = 4027623602077561066L;

    @EmbeddedId
    private BajaId bajaId;

    @ManyToOne
    @MapsId("idGrupo")
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    @ManyToOne
    @MapsId("noBoleta")
    @JoinColumn(name = "noBoleta")
    private Alumno alumno;

    @Column(nullable = false)
    private String reason;


    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "created")
    private Timestamp created;

    @UpdateTimestamp
    @Column(name = "updated")
    private Timestamp updated;

}
