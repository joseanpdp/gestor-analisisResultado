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

@Controller
@RequestMapping("/analisis")
public class AnalisisController {
    private static final Logger log = LoggerFactory.getLogger(AnalisisController.class);
    private final DocenteService docenteService;
    private final UsuarioService usuarioService;
    private final AsignaturaService asignaturaService;
    private final RespuestaService respuestaService;

    public AnalisisController(DocenteService docenteService, UsuarioService usuarioService, AsignaturaService asignaturaService, RespuestaService respuestaService) {
        this.docenteService = docenteService;
        this.usuarioService = usuarioService;
        this.asignaturaService = asignaturaService;
        this.respuestaService = respuestaService;
    }

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
            log.info("No hay respuestas");
            model.addAttribute("hayRespuestas", false);
        }
        return "analisis";
    }
}
