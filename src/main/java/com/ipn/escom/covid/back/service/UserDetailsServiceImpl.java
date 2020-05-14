package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.dto.UserDetailsImpl;
import com.ipn.escom.covid.back.entity.Admin;
import com.ipn.escom.covid.back.entity.Alumno;
import com.ipn.escom.covid.back.repository.AdminRepository;
import com.ipn.escom.covid.back.repository.AlumnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String s) {
        LOGGER.info("Finding user {}", s);
        Alumno alumno = alumnoRepository.findByNoBoleta(s).orElse(null);
        System.out.println(alumno);
        if (alumno != null) return UserDetailsImpl.builder().admin(null).alumno(alumno).isAdmin(false).build();
        Admin admin = adminRepository.findByNoBoleta(s).orElse(null);
        System.out.println(admin);
        if (admin != null) return UserDetailsImpl.builder().admin(admin).alumno(null).isAdmin(true).build();
        throw new UsernameNotFoundException(String.format("User %s not found", s));
    }
}
