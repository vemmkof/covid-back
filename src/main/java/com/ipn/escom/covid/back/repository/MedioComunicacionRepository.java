package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.MedioComunicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioComunicacionRepository extends CrudRepository<MedioComunicacion, String> {
}
