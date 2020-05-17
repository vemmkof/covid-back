package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.Alumno;
import com.ipn.escom.covid.back.entity.Grupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Integer> {

    List<Grupo> findAllByAlumno(Alumno alumno);

}
