package com.ipn.escom.covid.back.entity;

import com.ipn.escom.covid.back.entity.id.GrupoPorcentajeId;
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
public class GrupoPorcentaje implements Serializable {
    private static final long serialVersionUID = 3915533916113535221L;

    @EmbeddedId
    private GrupoPorcentajeId grupoPorcentajeId;

    @ManyToOne
    @MapsId("idGrupo")
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    @ManyToOne
    @MapsId("idPorcentaje")
    @JoinColumn(name = "idPorcentaje")
    private Porcentaje porcentaje;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "created")
    private Timestamp created;

    @UpdateTimestamp
    @Column(name = "updated")
    private Timestamp updated;
}
