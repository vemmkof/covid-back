package com.ipn.escom.covid.back.repository;

import com.ipn.escom.covid.back.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
    Optional<Admin> findByNoBoleta(String noBoleta);

}
