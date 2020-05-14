package com.ipn.escom.covid.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OauthRefreshToken implements Serializable {

    private static final long serialVersionUID = 8766191624805217983L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tokenId;

    @Lob
    @JsonIgnore
    @Column(nullable = false, length = 254 * 4)
    private byte[] token;

    @Lob
    @JsonIgnore
    @Column(nullable = false, length = 254 * 4)
    private byte[] authentication;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;


}
