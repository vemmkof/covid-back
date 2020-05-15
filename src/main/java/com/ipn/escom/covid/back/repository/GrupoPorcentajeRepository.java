package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.GrupoPorcentaje;
import com.ipn.escom.covid.back.entity.id.GrupoPorcentajeId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoPorcentajeRepository extends CrudRepository<GrupoPorcentaje, GrupoPorcentajeId> {
}
