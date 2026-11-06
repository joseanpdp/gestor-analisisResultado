package japdp.controller;

import japdp.ParserUtils;
import japdp.model.Docente;
import japdp.model.dto.response.DocenteResponseDTO;
import japdp.model.dto.response.DocenteResumenResponseDTO;
import japdp.service.AsignaturaService;
import japdp.service.DocenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los docentes.
 * Expone endpoints para consultar los docentes disponibles.
 */
@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "http://localhost:5500")
public class DocenteController {

    /**
     * Servicio encargado de la lógica de negocio de los docentes.
     */
    private final DocenteService docenteService;

    /**
     * Servicio encargado de la lógica de negocio de las asignaturas.
     */
    private final AsignaturaService asignaturaService;

    /**
     * Constructor del controlador.
     *
     * @param docenteService Servicio de docentes
     * @param asignaturaService Servicio de asignaturas
     */
    public DocenteController(DocenteService docenteService, AsignaturaService asignaturaService) {
        this.docenteService = docenteService;
        this.asignaturaService = asignaturaService;
    }

    /**
     * Obtiene todos los docentes disponibles.
     *
     * @return Lista de docentes en formato DTO resumido
     */
    @GetMapping
    public ResponseEntity<List<DocenteResumenResponseDTO>> findAll() {
        List<Docente> docentes = docenteService.findAll();
        List<DocenteResumenResponseDTO> docenteDtos = new ArrayList<>();

        for (Docente docente : docentes) {
            DocenteResumenResponseDTO docenteDto = ParserUtils.docenteToResumenResponseDto(docente);
            docenteDtos.add(docenteDto);
        }

        return ResponseEntity.ok(docenteDtos);
    }

    /**
     * Obtiene un docente por su identificador.
     *
     * @param id Identificador del docente
     * @return Docente encontrado o respuesta 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<DocenteResponseDTO> findById(@PathVariable Long id) {
        Optional<Docente> optional = docenteService.findById(id);

        if (!optional.isEmpty()) {
            Docente docente = optional.get();
            DocenteResponseDTO docenteDto = ParserUtils.docenteToResponseDto(docente);

            return ResponseEntity.ok(docenteDto);
        }

        return ResponseEntity.notFound().build();
    }
}