package japdp.controller;

import japdp.ParserUtils;
import japdp.model.Asignatura;
import japdp.model.dto.response.*;
import japdp.service.AsignaturaService;
import japdp.service.GrupoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST que gestiona las operaciones relacionadas con las asignaturas.
 * Expone endpoints para consultar las asignaturas disponibles.
 */
@RestController
@RequestMapping("/api/asignaturas")
@CrossOrigin(origins = "http://localhost:5500")
public class AsignaturaController {

    /**
     * Logger utilizado para registrar información de ejecución.
     */
    private static final Logger log = LoggerFactory.getLogger(AsignaturaController.class);

    /**
     * Servicio encargado de la lógica de negocio de las asignaturas.
     */
    private final AsignaturaService asignaturaService;

    /**
     * Servicio encargado de la lógica de negocio de los grupos.
     */
    private final GrupoService grupoService;

    /**
     * Constructor del controlador.
     *
     * @param asignaturaService Servicio de asignaturas
     * @param grupoService Servicio de grupos
     */
    public AsignaturaController(AsignaturaService asignaturaService, GrupoService grupoService) {
        this.asignaturaService = asignaturaService;
        this.grupoService = grupoService;
    }

    /**
     * Obtiene todas las asignaturas disponibles.
     *
     * @return Lista de asignaturas en formato DTO
     */
    @GetMapping
    public ResponseEntity<List<AsignaturaResponseDTO>> findAll() {
        List<Asignatura> asignaturas = asignaturaService.findAll();
        List<AsignaturaResponseDTO> asignaturaDtos = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            AsignaturaResponseDTO asignaturaDto = ParserUtils.asignaturaToResponseDto(asignatura);
            asignaturaDtos.add(asignaturaDto);
        }
        return ResponseEntity.ok(asignaturaDtos);
    }

    /**
     * Obtiene una asignatura por su identificador.
     *
     * @param id Identificador de la asignatura
     * @return Asignatura encontrada o respuesta 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaResponseDTO> findById(@PathVariable Long id) {
        Optional<Asignatura> optional = asignaturaService.findById(id);
        if (!optional.isEmpty()) {
            Asignatura asignatura = optional.get();
            AsignaturaResponseDTO asignaturaDto = ParserUtils.asignaturaToResponseDto(asignatura);
            return ResponseEntity.ok(asignaturaDto);
        }
        return ResponseEntity.notFound().build();
    }
}