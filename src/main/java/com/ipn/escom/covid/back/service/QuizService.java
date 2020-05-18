package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.dto.Answer;
import com.ipn.escom.covid.back.dto.MatrixRequest;
import com.ipn.escom.covid.back.dto.Response;
import com.ipn.escom.covid.back.dto.UserDto;
import com.ipn.escom.covid.back.entity.*;
import com.ipn.escom.covid.back.entity.id.GrupoPlataformaId;
import com.ipn.escom.covid.back.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class QuizService implements IQuizService {

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
        matrixRequest.getAnswers().forEach(answer -> {
            System.out.println();
            System.out.println(answer.toString());
            System.out.println();
            Grupo grupo = grupoRepository.findById(answer.getIdGrupo()).orElse(null);
            System.out.println();
            System.out.println(grupo.toString());
            System.out.println();
            saveGrupoPlataforma(answer, grupo);
            saveGrupoMedioComunicacion(answer, grupo);
            savePercent(answer, grupo);
        });
        alumno.setHaveAnswer(true);
        alumno = alumnoRepository.save(alumno);
        return Response.<UserDto>builder()
                .entity(UserDto.builder()
                        .plate(plate)
                        .email(alumno.getEmail())
                        .fullName(getFullName(alumno))
                        .applyQuiz(!alumno.isHaveAnswer())
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
                    .build();
            grupoMedioComunicacionRepository.save(grupoMedioComunicacion);
        });
    }

    @Transactional
    private void saveGrupoPlataforma(Answer answer, Grupo grupo) {
        Plataforma plataforma = plataformaRepository.findById(answer.getIdPlataforma()).orElse(null);
        System.out.println();
        System.out.println(plataforma);
        System.out.println();
        GrupoPlataforma grupoPlataforma = GrupoPlataforma.builder()
                .plataforma(plataforma)
                .grupo(grupo)
                .grupoPlataformaId(GrupoPlataformaId.builder()
                        .idGrupo(grupo.getIdGrupo())
                        .idPlataforma(plataforma.getIdPlataforma())
                        .build())
                .build();
        System.out.println(grupoPlataforma);
        grupoPlataformaRepository.save(grupoPlataforma);
        System.out.println("SI LO GUARDO XD");
    }

    private String getFullName(Alumno alumno) {
        return String.format("%s %s %s", alumno.getNombre(), alumno.getApellidoPaterno(), alumno.getApellidoMaterno());
    }
}
