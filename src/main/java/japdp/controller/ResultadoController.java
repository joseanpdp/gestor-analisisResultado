package japdp.controller;

import japdp.ParserUtils;
import japdp.model.*;
import japdp.model.dto.request.RespuestaRequestDTO;
import japdp.model.dto.request.ResultadoRequestDTO;
import japdp.model.dto.request.TemaResultadoRequestDTO;
import japdp.model.dto.response.AsignaturaResumenResponseDTO;
import japdp.model.dto.response.GrupoResumenResponseDTO;
import japdp.model.dto.response.ResultadoResponseDTO;
import japdp.service.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resultados")
@CrossOrigin(origins = "http://localhost:5500")
public class ResultadoController {

    private static final Logger log = LoggerFactory.getLogger(ResultadoController.class);
    private final ResultadoService resultadoService;
    private final AsignaturaService asignaturaService;
    private final GrupoService grupoService;
    private final DocenteService docenteService;
    private final RespuestaService respuestaService;
    private final TemaService temaService;
    private final TemaResultadoService temaResultadoService;

    public ResultadoController(ResultadoService resultadoService, AsignaturaService asignaturaService, GrupoService grupoService, DocenteService docenteService, RespuestaService respuestaService, TemaService temaService, TemaResultadoService temaResultadoService) {
        this.resultadoService = resultadoService;
        this.asignaturaService = asignaturaService;
        this.grupoService = grupoService;
        this.docenteService = docenteService;
        this.respuestaService = respuestaService;
        this.temaService = temaService;
        this.temaResultadoService = temaResultadoService;
    }

    @GetMapping
    public ResponseEntity<List<ResultadoResponseDTO>> findAll() {
        List<Resultado> resultados = resultadoService.findAll();
        List<ResultadoResponseDTO> asignaturaDocenteGrupoDtos = new ArrayList<>();
        for (Resultado resultado : resultados) {
            ResultadoResponseDTO asignaturaDocenteGrupoDto = ParserUtils.resultadoToResponseDto(resultado);
            asignaturaDocenteGrupoDtos.add(asignaturaDocenteGrupoDto);
        }
        return ResponseEntity.ok(asignaturaDocenteGrupoDtos);
    }

    @GetMapping("/docente/{docenteId}/asignatura/{asignaturaId}/grupo/{grupoId}")
    public ResponseEntity<ResultadoResponseDTO> findById(@PathVariable Long docenteId, @PathVariable Long asignaturaId, @PathVariable Long grupoId) {
        ResultadoId resultadoId = new ResultadoId(asignaturaId, docenteId, grupoId);
        Optional<Resultado> optional = resultadoService.findById(resultadoId);
        if (!optional.isEmpty()) {
            Resultado resultado = optional.get();
            ResultadoResponseDTO resultadoDto = ParserUtils.resultadoToResponseDto(resultado);
            return ResponseEntity.ok(resultadoDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/docente/{docenteId}")
    public ResponseEntity<List<AsignaturaResumenResponseDTO>> findAsignaturaByDocenteId(@PathVariable Long docenteId) {
        List<Asignatura> asignaturas = resultadoService.findAsignaturasByDocenteId(docenteId);
        List<AsignaturaResumenResponseDTO> docenteDtos = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            AsignaturaResumenResponseDTO docenteDto = ParserUtils.asignaturaToResumenResponseDto(asignatura);
            docenteDtos.add(docenteDto);
        }
        return ResponseEntity.ok(docenteDtos);
    }

    @GetMapping("/docente/{docenteId}/asignatura/{asignaturaId}")
    public ResponseEntity<List<GrupoResumenResponseDTO>> findGruposByDocenteIdAndAsignaturaId(@PathVariable Long docenteId, @PathVariable Long asignaturaId) {
        List<Grupo> grupos = resultadoService.findGruposByDocenteIdAndAsignaturaId(docenteId, asignaturaId);
        List<GrupoResumenResponseDTO> grupoDtos = new ArrayList<>();
        for (Grupo grupo : grupos) {
            GrupoResumenResponseDTO grupoDto = ParserUtils.grupoToResumenResponseDto(grupo);
            grupoDtos.add(grupoDto);
        }
        return ResponseEntity.ok(grupoDtos);
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public ResponseEntity<List<ResultadoResponseDTO>> findResultadosByAsignaturaId(@PathVariable Long asignaturaId) {
        List<Resultado> resultados = resultadoService.findResultadosByAsignaturaId(asignaturaId);
        List<ResultadoResponseDTO> resultadoDtos = new ArrayList<>();
        for (Resultado resultado : resultados) {
            ResultadoResponseDTO resultadoDto = ParserUtils.resultadoToResponseDto(resultado);
            resultadoDtos.add(resultadoDto);
        }
        return ResponseEntity.ok(resultadoDtos);
    }

    @PostMapping
    public ResponseEntity<ResultadoResponseDTO> saveResultado(@RequestBody ResultadoRequestDTO resultadoRequest) {
        log.info("El método se inicia");
        ResultadoId resultadoId = new ResultadoId(
                resultadoRequest.getAsignaturaId(),
                resultadoRequest.getDocenteId(),
                resultadoRequest.getGrupoId()
        );
        Optional<Resultado> resultadoOptional = resultadoService.findById(resultadoId);

        if (!resultadoOptional.isEmpty()) {
            log.info("Se encuentra un resultado");
            Resultado resultado = resultadoOptional.get();
            RespuestaRequestDTO respuestaRequest = resultadoRequest.getRespuesta();
            Respuesta respuesta = new Respuesta(
                    respuestaRequest.getNumeroAlumnosGrupo(),
                    respuestaRequest.getNumeroAlumnosAprobados(),
                    respuestaRequest.isDifEscasoHabito(),
                    respuestaRequest.isDifFaltaMotivacion(),
                    respuestaRequest.isDifBajoNivel(),
                    respuestaRequest.isDifPocaColaboracion(),
                    respuestaRequest.isDifInfluenciaClima(),
                    respuestaRequest.isDifCarenciaMedios(),
                    respuestaRequest.isDifMalAmbiente(),
                    respuestaRequest.getDifOtra(),
                    respuestaRequest.getPropuestasMejora()
            );
            List<TemaResultadoRequestDTO> temaResultadoDtos = resultadoRequest.getTemasResultados();
            List<TemaResultado> temasResultados = new ArrayList<>();
            for (TemaResultadoRequestDTO temaResultadoDto : temaResultadoDtos) {
                Optional<Tema> temaOptional = temaService.findById(temaResultadoDto.getTemaId());
                if (!temaOptional.isEmpty()) {
                    log.info("El tema existe");
                    Tema tema = temaOptional.get();
                    TemaResultado temaResultado = new TemaResultado(
                            tema,
                            resultado,
                            temaResultadoDto.isDesarrollada(),
                            temaResultadoDto.isEvaluada(),
                            temaResultadoDto.getObservaciones()
                    );
                    temasResultados.add(temaResultado);
                }
                else {
                    return ResponseEntity.notFound().build();
                }
            }
            respuesta.setResultado(resultado);
            respuestaService.save(respuesta);
            log.info("Se guarda correctamente la respuesta");
            resultado.setRespuesta(respuesta);
            resultadoService.save(resultado);
            log.info("Se guarda correctamente el resultado");
            temaResultadoService.saveAll(temasResultados);
            log.info("Se guardan correctamente los temas");
            return ResponseEntity.ok(ParserUtils.resultadoToResponseDto(resultado));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/estadistica/aprobados/asignatura/{asignaturaId}/grupo/{grupoId}")
    public ResponseEntity<String> loadGraficaTartaAprobadosByAsignaturaIdAndGrupoId(@PathVariable Long asignaturaId, @PathVariable Long grupoId) throws IOException {
        Optional<Resultado> optional = resultadoService.findResultadoByAsignaturaIdAndGrupoId(asignaturaId, grupoId);
        if (!optional.isEmpty()) {
            Resultado resultado = optional.get();
            Respuesta respuesta = resultado.getRespuesta();
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Aprobados", respuesta.getNumeroAlumnosAprobados());
            dataset.setValue("Suspensos", respuesta.getNumeroAlumnosGrupo() - respuesta.getNumeroAlumnosAprobados());

            JFreeChart chart = ChartFactory.createPieChart(
                    "Aprobados del grupo: " + resultado.getGrupo().getNombre(),
                    dataset,
                    true,
                    true,
                    false
            );
            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setBackgroundPaint(java.awt.Color.WHITE);
            chart.setBackgroundPaint(java.awt.Color.WHITE);

            BufferedImage bufferedImage = chart.createBufferedImage(1000, 800);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            String base64 = Base64.getEncoder().encodeToString(baos.toByteArray());
            return ResponseEntity.ok(base64);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/estadistica/aprobados/asignatura/{asignaturaId}")
    public ResponseEntity<String> loadGraficaBarrasByAsignaturaId(@PathVariable Long asignaturaId) throws IOException {
        List<Resultado> resultados = resultadoService.findResultadosByAsignaturaId(asignaturaId);
        if (!resultados.isEmpty()) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (Resultado resultado : resultados) {
                Respuesta respuesta = resultado.getRespuesta();
                if (respuesta != null) {
                    dataset.setValue(respuesta.getNumeroAlumnosAprobados(), "Aprobados", resultado.getGrupo().getNombre());
                    dataset.setValue(respuesta.getNumeroAlumnosGrupo() - respuesta.getNumeroAlumnosAprobados(), "Suspensos", resultado.getGrupo().getNombre());
                }
            }
            JFreeChart chart = ChartFactory.createBarChart(
                    "",
                    "Número de alumnos",
                    "Alumnos",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            plot.setBackgroundPaint(java.awt.Color.WHITE);
            chart.setBackgroundPaint(java.awt.Color.WHITE);

            BufferedImage bufferedImage = chart.createBufferedImage(1000, 800);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            String base64 = Base64.getEncoder().encodeToString(baos.toByteArray());
            return ResponseEntity.ok(base64);
        }
        return ResponseEntity.notFound().build();
    }
}