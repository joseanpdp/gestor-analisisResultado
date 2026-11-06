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

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin(origins = "http://localhost:5500")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

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

    /*@GetMapping("/asignatura/{asignaturaId}")
    public ResponseEntity<List<GrupoResumenResponseDTO>> findGruposByAsignaturaId(@PathVariable Long asignaturaId) {
        List<Grupo> grupos = grupoService.findGruposByAsignaturaId(asignaturaId);
        List<GrupoResumenResponseDTO> grupoDtos = new ArrayList<>();
        for (Grupo grupo : grupos) {
            GrupoResumenResponseDTO grupoDto = ParserUtils.grupoToResumenResponseDto(grupo);
            grupoDtos.add(grupoDto);
        }
        return ResponseEntity.ok(grupoDtos);
    }*/

    /*@PostMapping
    public ResponseEntity<GrupoResumenResponseDTO> save(@RequestBody GrupoRequestDTO grupoDto) {
        Grupo grupo = new Grupo();
        grupo.setNombre(grupoDto.getNombre());
        Grupo grupoGuardado = grupoService.save(grupo);
        return ResponseEntity
                .created(URI.create("/api/grupos/" + grupoGuardado.getId()))
                .body(ParserUtils.grupoToResumenResponseDto(grupoGuardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> update(
            @PathVariable Long id,
            @RequestBody Grupo grupo
    ) {
        if (grupoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        grupo.setId(id);

        return ResponseEntity.ok(grupoService.save(grupo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (grupoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        grupoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }*/
}
