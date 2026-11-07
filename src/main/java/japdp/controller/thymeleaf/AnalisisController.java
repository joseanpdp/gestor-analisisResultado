package japdp.controller.thymeleaf;

import japdp.ParserUtils;
import japdp.model.*;
import japdp.model.dto.response.AsignaturaResponseDTO;
import japdp.model.dto.response.ResultadoResponseDTO;
import japdp.service.AsignaturaService;
import japdp.service.DocenteService;
import japdp.service.RespuestaService;
import japdp.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Controlador que gestiona la vista de análisis de resultados.
 * Muestra estadísticas de alumnos, aprobados y porcentajes por asignatura y grupo.
 */
@Controller
@RequestMapping("/analisis")
public class AnalisisController {

    /**
     * Logger utilizado para registrar información de ejecución.
     */
    private static final Logger log = LoggerFactory.getLogger(AnalisisController.class);

    /**
     * Servicio encargado de la lógica de negocio de los docentes.
     */
    private final DocenteService docenteService;

    /**
     * Servicio encargado de la lógica de negocio de los usuarios.
     */
    private final UsuarioService usuarioService;

    /**
     * Servicio encargado de la lógica de negocio de las asignaturas.
     */
    private final AsignaturaService asignaturaService;

    /**
     * Servicio encargado de la lógica de negocio de las respuestas.
     */
    private final RespuestaService respuestaService;

    /**
     * Constructor del controlador.
     *
     * @param docenteService Servicio de docentes
     * @param usuarioService Servicio de usuarios
     * @param asignaturaService Servicio de asignaturas
     * @param respuestaService Servicio de respuestas
     */
    public AnalisisController(DocenteService docenteService, UsuarioService usuarioService, AsignaturaService asignaturaService, RespuestaService respuestaService) {
        this.docenteService = docenteService;
        this.usuarioService = usuarioService;
        this.asignaturaService = asignaturaService;
        this.respuestaService = respuestaService;
    }

    /**
     * Muestra la vista de análisis con los resultados disponibles.
     *
     * Calcula el número de alumnos, aprobados y porcentaje de aprobados
     * por asignatura y grupo, siempre que existan respuestas registradas.
     *
     * @param model Modelo para enviar datos a la vista
     * @return Nombre de la plantilla Thymeleaf
     */
    @GetMapping
    public String irAnalisis(Model model) {
        List<Respuesta> respuestas = respuestaService.findAll();
        if (!respuestas.isEmpty()) {
            List<Asignatura> asignaturas = asignaturaService.findAll();
            List<AsignaturaResponseDTO> asignaturasDto = new ArrayList<>();
            for (Asignatura asignatura : asignaturas) {
                AsignaturaResponseDTO asignaturaDto = ParserUtils.asignaturaToResponseDto(asignatura);
                asignaturasDto.add(asignaturaDto);
            }
            Map<String, List<ResultadoResponseDTO>> resultadosAsignatura = new LinkedHashMap<>();
            Map<String, Map<String, Integer[]>> numerosAlumnosGruposResultado = new LinkedHashMap<>();
            Map<String, Integer[]> totalNumerosResultado = new LinkedHashMap<>();
            for (Asignatura asignatura : asignaturas) {
                List<Resultado> resultados = asignatura.getResultados();
                List<ResultadoResponseDTO> resultadosDto = new ArrayList<>();
                for (Resultado resultado : resultados) {
                    if (resultado.getRespuesta() != null) {
                        ResultadoResponseDTO resultadoDto = ParserUtils.resultadoToResponseDto(resultado);
                        resultadosDto.add(resultadoDto);
                    }
                }
                String nombreNivel = asignatura.getNivel() + "-" + asignatura.getNombre();
                if (!resultadosDto.isEmpty()) {
                    resultadosAsignatura.put(nombreNivel, resultadosDto);
                }
                Map<String, Integer[]> numerosAlumnosGrupo = new LinkedHashMap<>();
                Integer[] totales = new Integer[3];
                int totalAlumnosGrupo = 0;
                int totalAlumnosAprobados = 0;
                for (Resultado resultado : resultados) {
                    if (resultado.getRespuesta() != null) {
                        Grupo grupo = resultado.getGrupo();
                        Respuesta respuesta = resultado.getRespuesta();
                        int numeroAlumnosGrupo = respuesta.getNumeroAlumnosGrupo();
                        int numeroAlumnosAprobados = respuesta.getNumeroAlumnosAprobados();
                        Integer[] numeros = new Integer[3];
                        numeros[0] = numeroAlumnosGrupo;
                        numeros[1] = numeroAlumnosAprobados;
                        numeros[2] = (respuesta.getNumeroAlumnosAprobados() * 100) / respuesta.getNumeroAlumnosGrupo();
                        numerosAlumnosGrupo.put(grupo.getNombre(), numeros);
                        totalAlumnosGrupo += numeroAlumnosGrupo;
                        totalAlumnosAprobados += numeroAlumnosAprobados;
                    }
                }
                if (totalAlumnosGrupo != 0) {
                    numerosAlumnosGruposResultado.put(nombreNivel, numerosAlumnosGrupo);
                    int totalPorcentaje = (totalAlumnosAprobados * 100) / totalAlumnosGrupo;
                    totales[0] = totalAlumnosGrupo;
                    totales[1] = totalAlumnosAprobados;
                    totales[2] = totalPorcentaje;
                    totalNumerosResultado.put(nombreNivel, totales);
                }
            }
            model.addAttribute("hayRespuestas", true);
            model.addAttribute("asignaturas", asignaturasDto);
            model.addAttribute("resultadosAsignatura", resultadosAsignatura);
            model.addAttribute("numerosAlumnosGruposResultado", numerosAlumnosGruposResultado);
            model.addAttribute("totalNumerosResultado", totalNumerosResultado);
        }
        else {
            model.addAttribute("hayRespuestas", false);
        }
        return "analisis";
    }
}