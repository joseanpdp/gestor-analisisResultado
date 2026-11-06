package japdp.controller;

import japdp.ParserUtils;
import japdp.model.Tema;
import japdp.model.dto.response.*;
import japdp.service.AsignaturaService;
import japdp.service.TemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los temas.
 * Expone endpoints para consultar los temas disponibles.
 */
@RestController
@RequestMapping("/api/temas")
@CrossOrigin(origins = "http://localhost:5500")
public class TemaController {

    /**
     * Servicio encargado de la lógica de negocio de los temas.
     */
    private final TemaService temaService;

    /**
     * Servicio encargado de la lógica de negocio de las asignaturas.
     */
    private final AsignaturaService asignaturaService;

    /**
     * Constructor del controlador.
     *
     * @param temaService Servicio de temas
     * @param asignaturaService Servicio de asignaturas
     */
    public TemaController(TemaService temaService, AsignaturaService asignaturaService) {
        this.temaService = temaService;
        this.asignaturaService = asignaturaService;
    }

    /**
     * Obtiene todos los temas disponibles.
     *
     * @return Lista de temas en formato DTO
     */
    @GetMapping
    public ResponseEntity<List<TemaResponseDTO>> findAll() {
        List<Tema> temas = temaService.findAll();
        List<TemaResponseDTO> unidadDtos = new ArrayList<>();

        for (Tema tema : temas) {
            TemaResponseDTO unidadDto = ParserUtils.temaToResponseDto(tema);
            unidadDtos.add(unidadDto);
        }

        return ResponseEntity.ok(unidadDtos);
    }

    /**
     * Obtiene un tema por su identificador.
     *
     * @param id Identificador del tema
     * @return Tema encontrado o respuesta 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<TemaResponseDTO> findById(@PathVariable Long id) {
        Optional<Tema> optional = temaService.findById(id);

        if (!optional.isEmpty()) {
            Tema tema = optional.get();
            TemaResponseDTO unidadDto = ParserUtils.temaToResponseDto(tema);

            return ResponseEntity.ok(unidadDto);
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Obtiene los temas asociados a una asignatura.
     *
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de temas en formato DTO resumido o respuesta 404
     */
    @GetMapping("/asignatura/{asignaturaId}")
    public ResponseEntity<List<TemaResumenResponseDTO>> findTemasByAsignaturaId(@PathVariable Long asignaturaId) {
        List<Tema> temas = temaService.findTemasByAsignaturaId(asignaturaId);
        if (!temas.isEmpty()) {
            List<TemaResumenResponseDTO> temaDtos = new ArrayList<>();
            for (Tema tema : temas) {
                TemaResumenResponseDTO temaDto = ParserUtils.temaToResumenResponseDto(tema);
                temaDtos.add(temaDto);
            }
            return ResponseEntity.ok(temaDtos);
        }
        return ResponseEntity.notFound().build();
    }
}