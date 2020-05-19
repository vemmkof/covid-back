package com.ipn.escom.covid.back.controller.api;

import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.entity.GrupoMedioComunicacion;
import com.ipn.escom.covid.back.entity.GrupoPlataforma;
import com.ipn.escom.covid.back.entity.GrupoPorcentaje;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface StatisticsApi {

    @GetMapping("/statistics/group/platform")
    ResponseEntity<Response<List<GrupoPlataforma>>> getGroupPlatforms();


    @GetMapping("/statistics/group/media")
    ResponseEntity<Response<List<GrupoMedioComunicacion>>> getGroupMedia();


    @GetMapping("/statistics/group/percent")
    ResponseEntity<Response<List<GrupoPorcentaje>>> getGroupPercents();
}
