package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.Grupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Integer> {
}
