package com.ipn.escom.covid.back.service;

import com.ipn.escom.covid.back.dto.*;
import com.ipn.escom.covid.back.entity.Alumno;
import com.ipn.escom.covid.back.entity.Baja;
import com.ipn.escom.covid.back.entity.Grupo;
import com.ipn.escom.covid.back.entity.UnidadAprendizaje;
import com.ipn.escom.covid.back.repository.AlumnoRepository;
import com.ipn.escom.covid.back.repository.BajaRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReportService implements IReportService {

    private static final OpenOption[] openOption = new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING,
            StandardOpenOption.CREATE};
    private final BajaRepository bajaRepository;
    private final AlumnoRepository alumnoRepository;

    @Value("${server.report.path}")
    protected String reportPath;

    @Override
    public FileBase64 getReport(String name) throws JRException {
        Alumno alumno = alumnoRepository.findByNoBoleta(name).orElse(null);
        List<Baja> bajas = bajaRepository.findByAlumno(alumno);
        Map<String, Object> parameters = getParameters(alumno, bajas);
        String base64 = "";
        JasperReport jasperReport = JasperCompileManager
                .compileReport(getClass().getResourceAsStream("/jasper/Comprobante.jrxml"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        byte[] is = JasperExportManager.exportReportToPdf(jasperPrint);
        base64 = new String(Base64.getEncoder().encode(is));
        return FileBase64.builder().base64(base64).fileName(String.format("comprobante-%s.pdf", name)).build();
    }

    @Override
    @SneakyThrows
    public UserDto saveReport(String name, FileBase64 report) {
        System.out.println(name);
        Alumno alumno = alumnoRepository.findByNoBoleta(name).orElse(null);
        System.out.println(alumno);
        if (alumno.getFileName() == null) {
            report.setBase64(report.getBase64().replaceAll("\n", ""));
            byte[] decoding = Base64.getDecoder().decode(report.getBase64().getBytes(StandardCharsets.UTF_8));
            String key = UUID.nameUUIDFromBytes(decoding).toString();
            String fileName = String.format("%s%s", key, report.getFileName());
            Path path = Paths.get(reportPath, fileName);
            Files.write(path, decoding, openOption);
            alumno.setFileName(fileName);
            alumnoRepository.save(alumno);
        }
        return UserDto.builder()
                .filePath(alumno.getFileName()).applyQuiz(false)
                .email(alumno.getEmail()).plate(name)
                .build();
    }

    @Override
    @SneakyThrows
    public FileBase64 downloadReport(String fileName) {
        Path dest = Paths.get(reportPath, fileName);
        byte[] src = Files.readAllBytes(dest);
        return FileBase64.builder().fileName(fileName).base64(Base64.getEncoder().encodeToString(src)).build();
    }

    @Override
    public BajasDto getBajaReport() {
        List<Baja> bajas = new ArrayList<>();
        return BajasDto.builder().bajas(
                StreamSupport.stream(
                        bajaRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList()))
                .build();
    }

    private Map<String, Object> getParameters(Alumno alumno, List<Baja> bajas) {
        Map<String, Object> parameters;
        parameters = new HashMap<>();
        parameters.put("report", getReporteDto(alumno));
        parameters.put("bajas", getBajasCollection(bajas));
        return parameters;
    }

    private JRBeanCollectionDataSource getBajasCollection(List<Baja> bajas) {
        return new JRBeanCollectionDataSource(
                bajas.stream().map(baja ->
                        BajaDto.builder()
                                .grupo(baja.getGrupo().getSecuencia())
                                .materia(getFullMateria(baja.getGrupo()))
                                .motivo(baja.getReason())
                                .build()
                ).collect(Collectors.toList()));
    }

    private String getFullMateria(Grupo grupo) {
        UnidadAprendizaje unidadAprendizaje = grupo.getUnidadAprendizaje();
        return String.format("%s - %s", unidadAprendizaje.getIdUnidadAprendizaje(), unidadAprendizaje.getNombreUnidadAprendizaje());
    }

    private ReportDto getReporteDto(Alumno alumno) {
        return ReportDto.builder()
                .email(alumno.getEmail())
                .fullName(getFullName(alumno))
                .noBoleta(alumno.getNoBoleta())
                .build();
    }

    private String getFullName(Alumno alumno) {
        return String.format("%s %s %s", alumno.getNombre(), alumno.getApellidoPaterno(), alumno.getApellidoMaterno());
    }
}
