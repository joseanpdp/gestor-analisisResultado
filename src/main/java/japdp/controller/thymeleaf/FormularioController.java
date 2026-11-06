package japdp.controller.thymeleaf;

import japdp.ParserUtils;
import japdp.model.*;
import japdp.model.dto.request.RespuestaRequestDTO;
import japdp.model.dto.request.ResultadoRequestDTO;
import japdp.model.dto.request.TemaResultadoRequestDTO;
import japdp.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
public class FormularioController {

    private static final Logger log = LoggerFactory.getLogger(FormularioController.class);
    private final DocenteService docenteService;
    private final AsignaturaService asignaturaService;
    private final GrupoService grupoService;
    private final TemaService temaService;
    private final ResultadoService resultadoService;
    private final RespuestaService respuestaService;
    private final TemaResultadoService temaResultadoService;

    public FormularioController(DocenteService docenteService, AsignaturaService asignaturaService, GrupoService grupoService, TemaService temaService, ResultadoService resultadoService, RespuestaService respuestaService, TemaResultadoService temaResultadoService) {
        this.docenteService = docenteService;
        this.asignaturaService = asignaturaService;
        this.grupoService = grupoService;
        this.temaService = temaService;
        this.resultadoService = resultadoService;
        this.respuestaService = respuestaService;
        this.temaResultadoService = temaResultadoService;
    }

    @GetMapping("/formulario")
    public String irFormulario(@RequestParam("docenteId") Long docenteId,
                               @RequestParam("asignaturaId") Long asignaturaId,
                               @RequestParam("grupoId") Long grupoId,
                               Model model) {
        Optional<Docente> optionalDocente = docenteService.findById(docenteId);
        Optional<Asignatura> optionalAsignatura = asignaturaService.findById(asignaturaId);
        Optional<Grupo> optionalGrupo = grupoService.findById(grupoId);
        ResultadoId resultadoId = new ResultadoId();
        resultadoId.setAsignaturaId(asignaturaId);
        resultadoId.setDocenteId(docenteId);
        resultadoId.setGrupoId(grupoId);
        Optional<Resultado> optionalResultado = resultadoService.findById(resultadoId);
        if (!optionalDocente.isEmpty() && !optionalAsignatura.isEmpty() &&
            !optionalGrupo.isEmpty() && !optionalResultado.isEmpty()) {
            Docente docente = optionalDocente.get();
            Asignatura asignatura = optionalAsignatura.get();
            Grupo grupo = optionalGrupo.get();
            Resultado resultado = optionalResultado.get();
            List<Tema> temas = asignatura.getTemas();
            ResultadoRequestDTO resultadoDto = new ResultadoRequestDTO();
            resultadoDto.setDocenteId(resultado.getDocente().getDocenteId());
            resultadoDto.setAsignaturaId(resultado.getAsignatura().getAsignaturaId());
            resultadoDto.setGrupoId(resultado.getGrupo().getGrupoId());

            if (resultado.getRespuesta() != null) {
                Respuesta respuesta = resultado.getRespuesta();
                RespuestaRequestDTO respuestaDto = new RespuestaRequestDTO(
                        respuesta.getNumeroAlumnosGrupo(),
                        respuesta.getNumeroAlumnosAprobados(),
                        respuesta.isDifEscasoHabito(),
                        respuesta.isDifFaltaMotivacion(),
                        respuesta.isDifBajoNivel(),
                        respuesta.isDifPocaColaboracion(),
                        respuesta.isDifInfluenciaClima(),
                        respuesta.isDifCarenciaMedios(),
                        respuesta.isDifMalAmbiente(),
                        respuesta.getDifOtra(),
                        respuesta.getPropuestasMejora()
                );
                resultadoDto.setRespuesta(respuestaDto);
                log.info("Hay una respuesta");
            }

            if (resultado.getTemasResultados() != null) {
                List<TemaResultado> temaResultados = resultado.getTemasResultados();
                List<TemaResultadoRequestDTO> temaResultadosDto = new ArrayList<>();
                for (TemaResultado temaResultado : temaResultados) {
                    TemaResultadoRequestDTO temaResultadoDto = new TemaResultadoRequestDTO();
                    temaResultadoDto.setTemaId(temaResultado.getTema().getTemaId());
                    temaResultadoDto.setDesarrollada(temaResultado.isDesarrollada());
                    temaResultadoDto.setEvaluada(temaResultado.isEvaluada());
                    temaResultadoDto.setObservaciones(temaResultado.getObservaciones());
                    temaResultadosDto.add(temaResultadoDto);
                    log.info("Hay un tema resultado");
                }
                resultadoDto.setTemasResultados(temaResultadosDto);

            }
            else {
                resultadoDto.setTemasResultados(new ArrayList<>());
            }
            model.addAttribute("docente", docente);
            model.addAttribute("asignatura", asignatura);
            model.addAttribute("grupo", grupo);
            model.addAttribute("temas", temas);
            model.addAttribute("resultado", resultadoDto);
            return "formulario";
        }
        model.addAttribute("mensaje", "Algo ha salido mal");
        return "error";
    }

    @PostMapping("/formulario/guardar")
    public String guardarFormulario(@ModelAttribute ResultadoRequestDTO resultadoDto,
                                    RedirectAttributes redirectAttributes) {
        ResultadoId resultadoId = new ResultadoId(
                resultadoDto.getAsignaturaId(),
                resultadoDto.getDocenteId(),
                resultadoDto.getGrupoId()
        );
        log.info("Docente id: {}", resultadoDto.getDocenteId());
        log.info("Asignatura id: {}", resultadoDto.getAsignaturaId());
        log.info("Grupo id: {}", resultadoDto.getGrupoId());
        Optional<Resultado> resultadoOptional = resultadoService.findById(resultadoId);
        if (!resultadoOptional.isEmpty()) {
            Resultado resultado = resultadoOptional.get();
            RespuestaRequestDTO respuestaDto = resultadoDto.getRespuesta();
            int alumnosGrupo = respuestaDto.getNumeroAlumnosGrupo();
            int alumnosAprobados = respuestaDto.getNumeroAlumnosAprobados();
            if (alumnosGrupo >= alumnosAprobados) {
                Respuesta respuesta = new Respuesta(
                        alumnosGrupo,
                        alumnosAprobados,
                        respuestaDto.isDifEscasoHabito(),
                        respuestaDto.isDifFaltaMotivacion(),
                        respuestaDto.isDifBajoNivel(),
                        respuestaDto.isDifPocaColaboracion(),
                        respuestaDto.isDifInfluenciaClima(),
                        respuestaDto.isDifCarenciaMedios(),
                        respuestaDto.isDifMalAmbiente(),
                        respuestaDto.getDifOtra(),
                        respuestaDto.getPropuestasMejora()
                );
                List<TemaResultadoRequestDTO> temaResultadoDtos = resultadoDto.getTemasResultados();
                List<TemaResultado> temasResultados = new ArrayList<>();
                for (TemaResultadoRequestDTO temaResultadoDto : temaResultadoDtos) {
                    Optional<Tema> temaOptional = temaService.findById(temaResultadoDto.getTemaId());
                    if (!temaOptional.isEmpty()) {
                        Tema tema = temaOptional.get();
                        TemaResultado temaResultado = new TemaResultado(
                                tema,
                                resultado,
                                temaResultadoDto.isDesarrollada(),
                                temaResultadoDto.isEvaluada(),
                                temaResultadoDto.getObservaciones()
                        );
                        temasResultados.add(temaResultado);
                    } else {
                        redirectAttributes.addFlashAttribute("mensaje", "Algo ha salido mal");
                        redirectAttributes.addFlashAttribute("tipo", "error");
                        return "redirect:/?docenteId=" + resultadoDto.getDocenteId();
                    }
                }
                respuesta.setResultado(resultado);
                respuestaService.save(respuesta);
                resultado.setRespuesta(respuesta);
                resultadoService.save(resultado);
                temaResultadoService.saveAll(temasResultados);
                redirectAttributes.addFlashAttribute("tipo", "exito");
                redirectAttributes.addFlashAttribute("mensaje", "El análisis se ha guardado correctamente");
                return "redirect:/?docenteId=" + resultadoDto.getDocenteId();
            }
            else {
                redirectAttributes.addFlashAttribute("tipo", "error");
                redirectAttributes.addFlashAttribute("mensaje", "El número de aprobados no puede ser mayor que el número de alumnos del grupo.");
                return "redirect:/formulario?docenteId=" + resultadoDto.getDocenteId() +
                        "&asignaturaId=" + resultadoId.getAsignaturaId() +
                        "&grupoId=" + resultadoId.getGrupoId();
            }
        }
        redirectAttributes.addFlashAttribute("tipo", "error");
        redirectAttributes.addFlashAttribute("mensaje", "Ha habido un problema con el docente, asignatura o grupo");
        return "redirect:/error";
    }
}
