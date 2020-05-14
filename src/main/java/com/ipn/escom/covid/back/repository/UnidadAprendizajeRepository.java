package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.UnidadAprendizaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadAprendizajeRepository extends CrudRepository<UnidadAprendizaje, String> {
}
