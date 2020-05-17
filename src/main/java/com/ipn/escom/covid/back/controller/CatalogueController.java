package com.ipn.escom.covid.back.controller;

import com.ipn.escom.covid.back.controller.api.CatalogueApi;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.entity.MedioComunicacion;
import com.ipn.escom.covid.back.entity.Plataforma;
import com.ipn.escom.covid.back.entity.Porcentaje;
import com.ipn.escom.covid.back.repository.MedioComunicacionRepository;
import com.ipn.escom.covid.back.repository.PlataformaRepository;
import com.ipn.escom.covid.back.repository.PorcentajeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class CatalogueController implements CatalogueApi {

    private final PlataformaRepository plataformaRepository;
    private final MedioComunicacionRepository medioComunicacionRepository;
    private final PorcentajeRepository porcentajeRepository;


    @Override
    public ResponseEntity<Response<ArrayList<Plataforma>>> getPlatform() {
        return ResponseEntity.ok(Response.<ArrayList<Plataforma>>builder()
                .entity((ArrayList<Plataforma>) plataformaRepository.findAll())
                .message("Platforms was found")
                .build());
    }

    @Override
    public ResponseEntity<Response<ArrayList<MedioComunicacion>>> getMedia() {
        return ResponseEntity.ok(Response.<ArrayList<MedioComunicacion>>builder()
                .entity((ArrayList<MedioComunicacion>) medioComunicacionRepository.findAll())
                .message("Medias was found")
                .build());
    }

    @Override
    public ResponseEntity<Response<ArrayList<Porcentaje>>> getPercent() {
        return ResponseEntity.ok(Response.<ArrayList<Porcentaje>>builder()
                .entity((ArrayList<Porcentaje>) porcentajeRepository.findAll())
                .message("Percents was found")
                .build());
    }
}
