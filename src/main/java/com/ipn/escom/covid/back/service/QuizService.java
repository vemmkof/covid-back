package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.dto.MatrixRequest;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import com.ipn.escom.covid.back.entity.Alumno;
import com.ipn.escom.covid.back.entity.Baja;
import com.ipn.escom.covid.back.entity.Grupo;
import com.ipn.escom.covid.back.entity.id.BajaId;
import com.ipn.escom.covid.back.repository.AlumnoRepository;
import com.ipn.escom.covid.back.repository.BajaRepository;
import com.ipn.escom.covid.back.repository.GrupoRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class QuizService implements IQuizService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuizService.class.getName());
    private final AlumnoRepository alumnoRepository;
    private final GrupoRepository grupoRepository;
    private final BajaRepository bajaRepository;

    @Override
    @Transactional
    public Response<UserDto> saveMatrix(String plate, MatrixRequest matrixRequest) {
        Alumno alumno = alumnoRepository.findByNoBoleta(plate).orElse(null);
        if (!alumno.isHaveAnswer()) {
            LOGGER.info("User have no answers registered.");
            Alumno finalAlumno = alumno;
            matrixRequest.getAnswers().stream()
                    .filter(answer -> answer.isBaja())
                    .forEach(answer -> {
                        Grupo grupo = grupoRepository.findById(answer.getIdGrupo()).orElse(null);
                        Baja baja = Baja.builder()
                                .alumno(finalAlumno)
                                .grupo(grupo)
                                .reason(answer.getMotivo())
                                .bajaId(BajaId.builder()
                                        .idGrupo(grupo.getIdGrupo()).noBoleta(finalAlumno.getNoBoleta())
                                        .build())
                                .build();
                        bajaRepository.save(baja);
                    });
            alumno.setHaveAnswer(true);
            alumno = alumnoRepository.save(alumno);

        }
        return Response.<UserDto>builder()
                .entity(UserDto.builder()
                        .plate(plate).email(alumno.getEmail())
                        .fullName(getFullName(alumno)).applyQuiz(!alumno.isHaveAnswer())
                        .build())
                .message("Successful quiz answered.")
                .build();
    }


    private String getFullName(Alumno alumno) {
        return String.format("%s %s %s", alumno.getNombre(), alumno.getApellidoPaterno(), alumno.getApellidoMaterno());
    }
}
