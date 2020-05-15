package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.GrupoMedioComunicacion;
import com.ipn.escom.covid.back.entity.id.GrupoMedioComunicacionId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoMedioComunicacionRepository extends CrudRepository<GrupoMedioComunicacion, GrupoMedioComunicacionId> {
}
