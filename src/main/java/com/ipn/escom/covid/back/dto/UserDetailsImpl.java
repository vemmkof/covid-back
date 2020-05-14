package com.ipn.escom.covid.back.dto;

import com.ipn.escom.covid.back.entity.Admin;
import com.ipn.escom.covid.back.entity.Alumno;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Builder
public class UserDetailsImpl implements UserDetails {
    public static final String STUDENT_ROLE = "STUDENT";
    public static final String ADMIN_ROLE = "ADMIN";
    private static final long serialVersionUID = 4610565622608764672L;
    private final Alumno alumno;
    private final Admin admin;
    private final boolean isAdmin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(isAdmin ? ADMIN_ROLE : STUDENT_ROLE)
                .stream().map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return isAdmin ? admin.getCURP() : alumno.getCURP();
    }

    @Override
    public String getUsername() {
        return isAdmin ? admin.getNoBoleta() : alumno.getNoBoleta();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
