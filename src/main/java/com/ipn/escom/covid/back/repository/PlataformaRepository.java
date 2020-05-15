package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.Plataforma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends CrudRepository<Plataforma, String>{
}
