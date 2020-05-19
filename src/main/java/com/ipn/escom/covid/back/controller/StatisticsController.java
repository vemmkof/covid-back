package com.ipn.escom.covid.back.controller;

import com.ipn.escom.covid.back.controller.api.StatisticsApi;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.entity.GrupoMedioComunicacion;
import com.ipn.escom.covid.back.entity.GrupoPlataforma;
import com.ipn.escom.covid.back.entity.GrupoPorcentaje;
import com.ipn.escom.covid.back.repository.GrupoMedioComunicacionRepository;
import com.ipn.escom.covid.back.repository.GrupoPlataformaRepository;
import com.ipn.escom.covid.back.repository.GrupoPorcentajeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StatisticsController implements StatisticsApi {

    private final GrupoPlataformaRepository grupoPlataformaRepository;
    private final GrupoMedioComunicacionRepository grupoMedioComunicacionRepository;
    private final GrupoPorcentajeRepository grupoPorcentajeRepository;


    @Override
    public ResponseEntity<Response<List<GrupoPlataforma>>> getGroupPlatforms() {
        return ResponseEntity.ok(Response.<List<GrupoPlataforma>>builder()
                .entity((List<GrupoPlataforma>) grupoPlataformaRepository.findAll())
                .message("Group/Platforms was found")
                .build());
    }

    @Override
    public ResponseEntity<Response<List<GrupoMedioComunicacion>>> getGroupMedia() {
        return ResponseEntity.ok(Response.<List<GrupoMedioComunicacion>>builder()
                .entity((List<GrupoMedioComunicacion>) grupoMedioComunicacionRepository.findAll())
                .message("Group/Media was found")
                .build());
    }

    @Override
    public ResponseEntity<Response<List<GrupoPorcentaje>>> getGroupPercents() {
        return ResponseEntity.ok(Response.<List<GrupoPorcentaje>>builder()
                .entity((List<GrupoPorcentaje>) grupoPorcentajeRepository.findAll())
                .message("Group/Percent was found")
                .build());
    }
}
