package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, String> {
    Optional<Alumno> findByNoBoleta(String noBoleta);
}
