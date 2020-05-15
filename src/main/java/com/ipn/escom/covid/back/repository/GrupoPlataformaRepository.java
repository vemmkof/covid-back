package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.GrupoPlataforma;
import com.ipn.escom.covid.back.entity.id.GrupoPlataformaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoPlataformaRepository extends CrudRepository<GrupoPlataforma, GrupoPlataformaId> {
}
