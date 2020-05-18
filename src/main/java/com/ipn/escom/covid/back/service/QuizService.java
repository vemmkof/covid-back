package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.dto.Answer;
import com.ipn.escom.covid.back.dto.MatrixRequest;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import com.ipn.escom.covid.back.entity.*;
import com.ipn.escom.covid.back.entity.id.GrupoMedioComunicacionId;
import com.ipn.escom.covid.back.entity.id.GrupoPlataformaId;
import com.ipn.escom.covid.back.entity.id.GrupoPorcentajeId;
import com.ipn.escom.covid.back.repository.*;
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
    private final PlataformaRepository plataformaRepository;
    private final MedioComunicacionRepository medioComunicacionRepository;
    private final PorcentajeRepository porcentajeRepository;
    private final GrupoPlataformaRepository grupoPlataformaRepository;
    private final GrupoMedioComunicacionRepository grupoMedioComunicacionRepository;
    private final GrupoPorcentajeRepository grupoPorcentajeRepository;

    @Override
    @Transactional
    public Response<UserDto> saveMatrix(String plate, MatrixRequest matrixRequest) {
        Alumno alumno = alumnoRepository.findByNoBoleta(plate).orElse(null);
        if (!alumno.isHaveAnswer()) {
            LOGGER.info("User have no answers registered.");
            matrixRequest.getAnswers().forEach(answer -> {
                Grupo grupo = grupoRepository.findById(answer.getIdGrupo()).orElse(null);
                saveGrupoPlataforma(answer, grupo);
                saveGrupoMedioComunicacion(answer, grupo);
                savePercent(answer, grupo);
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

    @Transactional
    private void savePercent(Answer answer, Grupo grupo) {
        Porcentaje porcentaje = porcentajeRepository.findById(answer.getIdPorcentaje()).orElse(null);
        GrupoPorcentaje grupoPorcentaje = GrupoPorcentaje.builder()
                .porcentaje(porcentaje)
                .grupo(grupo)
                .grupoPorcentajeId(GrupoPorcentajeId.builder()
                        .idPorcentaje(porcentaje.getIdPorcentaje())
                        .idGrupo(grupo.getIdGrupo())
                        .build())
                .build();
        grupoPorcentajeRepository.save(grupoPorcentaje);
    }

    @Transactional
    private void saveGrupoMedioComunicacion(Answer answer, Grupo grupo) {
        answer.getIdsMedioComunicacion().forEach(idMedio -> {
            MedioComunicacion medioComunicacion = medioComunicacionRepository.findById(idMedio).orElse(null);
            GrupoMedioComunicacion grupoMedioComunicacion = GrupoMedioComunicacion.builder()
                    .medioComunicacion(medioComunicacion)
                    .grupo(grupo)
                    .grupoMedioComunicacionId(GrupoMedioComunicacionId.builder()
                            .idMedioComunicacion(medioComunicacion.getIdMedioComunicacion())
                            .idGrupo(grupo.getIdGrupo())
                            .build())
                    .build();
            grupoMedioComunicacionRepository.save(grupoMedioComunicacion);
        });
    }

    @Transactional
    private void saveGrupoPlataforma(Answer answer, Grupo grupo) {
        Plataforma plataforma = plataformaRepository.findById(answer.getIdPlataforma()).orElse(null);
        GrupoPlataforma grupoPlataforma = GrupoPlataforma.builder()
                .plataforma(plataforma)
                .grupo(grupo)
                .grupoPlataformaId(GrupoPlataformaId.builder()
                        .idGrupo(grupo.getIdGrupo())
                        .idPlataforma(plataforma.getIdPlataforma())
                        .build())
                .build();
        grupoPlataformaRepository.save(grupoPlataforma);
    }

    private String getFullName(Alumno alumno) {
        return String.format("%s %s %s", alumno.getNombre(), alumno.getApellidoPaterno(), alumno.getApellidoMaterno());
    }
}
