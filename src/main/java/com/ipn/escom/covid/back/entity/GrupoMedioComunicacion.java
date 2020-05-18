package com.ipn.escom.covid.back.entity;

import com.ipn.escom.covid.back.entity.id.GrupoMedioComunicacionId;
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
public class GrupoMedioComunicacion implements Serializable {
    private static final long serialVersionUID = 7593198433064868315L;
    @EmbeddedId
    private GrupoMedioComunicacionId grupoMedioComunicacionId;

    @ManyToOne
    @MapsId("idGrupo")
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    @ManyToOne
    @MapsId("idMedioComunicacion")
    @JoinColumn(name = "idMedioComunicacion")
    private MedioComunicacion medioComunicacion;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "created")
    private Timestamp created;

    @UpdateTimestamp
    @Column(name = "updated")
    private Timestamp updated;
}
