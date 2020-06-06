package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.Baja;
import com.ipn.escom.covid.back.entity.id.BajaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BajaRepository extends CrudRepository<Baja, BajaId> {
}
