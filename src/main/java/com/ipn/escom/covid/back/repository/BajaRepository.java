package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.Alumno;
import com.ipn.escom.covid.back.entity.Baja;
import com.ipn.escom.covid.back.entity.id.BajaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BajaRepository extends CrudRepository<Baja, BajaId> {

    List<Baja> findByAlumno(Alumno alumno);
}
