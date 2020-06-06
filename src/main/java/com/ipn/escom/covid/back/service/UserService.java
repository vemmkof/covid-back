package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.dto.GroupsDto;
import com.ipn.escom.covid.back.dto.UserDto;
import com.ipn.escom.covid.back.entity.Admin;
import com.ipn.escom.covid.back.entity.Alumno;
import com.ipn.escom.covid.back.repository.AdminRepository;
import com.ipn.escom.covid.back.repository.AlumnoRepository;
import com.ipn.escom.covid.back.repository.GrupoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final AlumnoRepository alumnoRepository;
    private final AdminRepository adminRepository;
    private final GrupoRepository grupoRepository;

    @Override
    public UserDto getUser(final String plate) {
        final Alumno alumno = this.alumnoRepository.findByNoBoleta(plate).orElse(null);
        if (alumno != null) {
            return UserDto.builder()
                    .fullName(this.getFullName(alumno))
                    .email(alumno.getEmail())
                    .plate(plate)
                    .applyQuiz(!alumno.isHaveAnswer())
                    .filePath(alumno.getFilePath())
                    .build();
        }
        final Admin admin = this.adminRepository.findByNoBoleta(plate).orElse(null);
        return UserDto.builder()
                .fullName(this.getFullName(admin))
                .email(admin.getEmail())
                .plate(plate)
                .applyQuiz(false)
                .build();
    }

    @Override
    public GroupsDto getUserGroups(final String plate) {
        final Alumno alumno = this.alumnoRepository.findByNoBoleta(plate).orElse(null);
//        if (alumno == null || alumno.isHaveAnswer()) return null;
        return GroupsDto.builder().groups(this.grupoRepository.findAllByAlumno(alumno)).build();
    }

    private String getFullName(final Admin admin) {
        return String.format("%s %s %s", admin.getNombre(), admin.getApellidoPaterno(), admin.getApellidoMaterno());
    }

    private String getFullName(final Alumno alumno) {
        return String.format("%s %s %s", alumno.getNombre(), alumno.getApellidoPaterno(), alumno.getApellidoMaterno());
    }
}
