package com.ipn.escom.covid.back.controller.api;

import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.entity.MedioComunicacion;
import com.ipn.escom.covid.back.entity.Plataforma;
import com.ipn.escom.covid.back.entity.Porcentaje;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

public interface CatalogueApi {

    @GetMapping("/catalogue/platform")
    ResponseEntity<Response<ArrayList<Plataforma>>> getPlatform();

    @GetMapping("/catalogue/media")
    ResponseEntity<Response<ArrayList<MedioComunicacion>>> getMedia();

    @GetMapping("/catalogue/percent")
    ResponseEntity<Response<ArrayList<Porcentaje>>> getPercent();

}
