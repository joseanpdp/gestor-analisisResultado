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

@RestController
@RequestMapping("/api/temas")
@CrossOrigin(origins = "http://localhost:5500")
public class TemaController {

    private final TemaService temaService;
    private final AsignaturaService asignaturaService;

    public TemaController(TemaService temaService, AsignaturaService asignaturaService) {
        this.temaService = temaService;
        this.asignaturaService = asignaturaService;
    }

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

    /*@PostMapping
    public ResponseEntity<UnidadSimpleResponseDTO> save(@RequestBody UnidadRequestDTO unidadDto) {
        Optional<Asignatura> optional = asignaturaService.findById(unidadDto.getAsignaturaId());
        if (!optional.isEmpty()) {
            Unidad unidad = new Unidad();
            unidad.setNombre(unidadDto.getNombre());
            unidad.setAsignatura(optional.get());
            Unidad unidadGuardada = unidadService.save(unidad);
            return ResponseEntity
                    .created(URI.create("/api/unidades/" + unidadGuardada.getId()))
                    .body(ParserUtils.unidadToSimpleResponseDto(unidadGuardada));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidad> update(
            @PathVariable Long id,
            @RequestBody Unidad unidad
    ) {
        if (unidadService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        unidad.setId(id);

        return ResponseEntity.ok(unidadService.save(unidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (unidadService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        unidadService.deleteById(id);

        return ResponseEntity.noContent().build();
    }*/
}