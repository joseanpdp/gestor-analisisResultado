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

/**
 * Controlador REST que gestiona las operaciones relacionadas con los resultados.
 * Expone endpoints para consultar, crear y generar estadísticas de resultados.
 */
@RestController
@RequestMapping("/api/resultados")
@CrossOrigin(origins = "http://localhost:5500")
public class ResultadoController {

    /**
     * Logger utilizado para registrar información de ejecución.
     */
    private static final Logger log = LoggerFactory.getLogger(ResultadoController.class);

    /**
     * Servicio encargado de la lógica de negocio de los resultados.
     */
    private final ResultadoService resultadoService;

    /**
     * Servicio encargado de la lógica de negocio de las asignaturas.
     */
    private final AsignaturaService asignaturaService;

    /**
     * Servicio encargado de la lógica de negocio de los grupos.
     */
    private final GrupoService grupoService;

    /**
     * Servicio encargado de la lógica de negocio de los docentes.
     */
    private final DocenteService docenteService;

    /**
     * Servicio encargado de la lógica de negocio de las respuestas.
     */
    private final RespuestaService respuestaService;

    /**
     * Servicio encargado de la lógica de negocio de los temas.
     */
    private final TemaService temaService;

    /**
     * Servicio encargado de la lógica de negocio de las relaciones tema-resultado.
     */
    private final TemaResultadoService temaResultadoService;

    /**
     * Constructor del controlador.
     *
     * @param resultadoService Servicio de resultados
     * @param asignaturaService Servicio de asignaturas
     * @param grupoService Servicio de grupos
     * @param docenteService Servicio de docentes
     * @param respuestaService Servicio de respuestas
     * @param temaService Servicio de temas
     * @param temaResultadoService Servicio de relaciones tema-resultado
     */
    public ResultadoController(ResultadoService resultadoService, AsignaturaService asignaturaService, GrupoService grupoService, DocenteService docenteService, RespuestaService respuestaService, TemaService temaService, TemaResultadoService temaResultadoService) {
        this.resultadoService = resultadoService;
        this.asignaturaService = asignaturaService;
        this.grupoService = grupoService;
        this.docenteService = docenteService;
        this.respuestaService = respuestaService;
        this.temaService = temaService;
        this.temaResultadoService = temaResultadoService;
    }

    /**
     * Obtiene todos los resultados disponibles.
     *
     * @return Lista de resultados en formato DTO
     */
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

    /**
     * Obtiene un resultado por los identificadores de docente, asignatura y grupo.
     *
     * @param docenteId Identificador del docente
     * @param asignaturaId Identificador de la asignatura
     * @param grupoId Identificador del grupo
     * @return Resultado encontrado o respuesta 404
     */
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

    /**
     * Obtiene las asignaturas asociadas a un docente.
     *
     * @param docenteId Identificador del docente
     * @return Lista de asignaturas en formato DTO resumido
     */
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

    /**
     * Obtiene los grupos asociados a un docente y una asignatura.
     *
     * @param docenteId Identificador del docente
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de grupos en formato DTO resumido
     */
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

    /**
     * Obtiene los resultados asociados a una asignatura.
     *
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de resultados en formato DTO
     */
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

    /**
     * Guarda o actualiza un resultado con su respuesta y temas evaluados.
     *
     * @param resultadoRequest Datos del resultado a guardar
     * @return Resultado guardado o respuesta 404
     */
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

    /**
     * Genera una gráfica de tarta con los alumnos aprobados y suspensos
     * de una asignatura y grupo concretos.
     *
     * @param asignaturaId Identificador de la asignatura
     * @param grupoId Identificador del grupo
     * @return Imagen de la gráfica en formato Base64 o respuesta 404
     * @throws IOException Si ocurre un error al generar la imagen
     */
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

    /**
     * Genera una gráfica de barras con los alumnos aprobados y suspensos
     * de todos los grupos de una asignatura.
     *
     * @param asignaturaId Identificador de la asignatura
     * @return Imagen de la gráfica en formato Base64 o respuesta 404
     * @throws IOException Si ocurre un error al generar la imagen
     */
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