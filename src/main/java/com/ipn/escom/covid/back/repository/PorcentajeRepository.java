package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.Porcentaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorcentajeRepository extends CrudRepository<Porcentaje, Integer> {
}
