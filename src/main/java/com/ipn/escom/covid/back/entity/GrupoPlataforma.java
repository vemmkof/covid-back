package com.ipn.escom.covid.back.entity;

import com.ipn.escom.covid.back.entity.id.GrupoPlataformaId;
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
public class GrupoPlataforma implements Serializable {

    private static final long serialVersionUID = -8287122243543410271L;

    @EmbeddedId
    private GrupoPlataformaId grupoPlataformaId;

    @ManyToOne
    @MapsId("idGrupo")
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    @ManyToOne
    @MapsId("idPlataforma")
    @JoinColumn(name = "idPlataforma")
    private Plataforma plataforma;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "created")
    private Timestamp created;

    @UpdateTimestamp
    @Column(name = "updated")
    private Timestamp updated;
}
