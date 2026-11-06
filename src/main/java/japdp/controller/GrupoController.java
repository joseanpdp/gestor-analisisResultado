package japdp.controller;

import japdp.ParserUtils;
import japdp.model.Grupo;
import japdp.model.dto.response.GrupoResponseDTO;
import japdp.model.dto.response.GrupoResumenResponseDTO;
import japdp.service.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los grupos.
 * Expone endpoints para consultar los grupos disponibles.
 */
@RestController
@RequestMapping("/api/grupos")
@CrossOrigin(origins = "http://localhost:5500")
public class GrupoController {

    /**
     * Servicio encargado de la lógica de negocio de los grupos.
     */
    private final GrupoService grupoService;

    /**
     * Constructor del controlador.
     *
     * @param grupoService Servicio de grupos
     */
    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    /**
     * Obtiene todos los grupos disponibles.
     *
     * @return Lista de grupos en formato DTO resumido
     */
    @GetMapping
    public ResponseEntity<List<GrupoResumenResponseDTO>> findAll() {
        List<Grupo> grupos = grupoService.findAll();
        List<GrupoResumenResponseDTO> grupoDtos = new ArrayList<>();

        for (Grupo grupo : grupos) {
            GrupoResumenResponseDTO grupoDto = ParserUtils.grupoToResumenResponseDto(grupo);
            grupoDtos.add(grupoDto);
        }

        return ResponseEntity.ok(grupoDtos);
    }

    /**
     * Obtiene un grupo por su identificador.
     *
     * @param id Identificador del grupo
     * @return Grupo encontrado o respuesta 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<GrupoResponseDTO> findById(@PathVariable Long id) {
        Optional<Grupo> optional = grupoService.findById(id);

        if (!optional.isEmpty()) {
            Grupo grupo = optional.get();
            GrupoResponseDTO grupoDto = ParserUtils.grupoToResponseDto(grupo);

            return ResponseEntity.ok(grupoDto);
        }

        return ResponseEntity.notFound().build();
    }
}