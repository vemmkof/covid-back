package com.ipn.escom.covid.back.dto;

import com.ipn.escom.covid.back.entity.Baja;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BajasDto implements Serializable {
    private static final long serialVersionUID = -7617591231844598449L;
    private List<Baja> bajas;
}
