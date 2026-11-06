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

@RestController
@RequestMapping("/api/asignaturas")
@CrossOrigin(origins = "http://localhost:5500")
public class AsignaturaController {

    private static final Logger log = LoggerFactory.getLogger(AsignaturaController.class);
    private final AsignaturaService asignaturaService;
    private final GrupoService grupoService;

    public AsignaturaController(AsignaturaService asignaturaService, GrupoService grupoService) {
        this.asignaturaService = asignaturaService;
        this.grupoService = grupoService;
    }

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

    /*@PostMapping
    public ResponseEntity<AsignaturaSimpleResponseDTO> save(@RequestBody AsignaturaRequestDTO asignaturaDto) {
        Optional<Grupo> optional = grupoService.findById(asignaturaDto.getGrupoId());
        if (!optional.isEmpty()) {
            Asignatura asignatura = new Asignatura();
            asignatura.setNombre(asignaturaDto.getNombre());
            asignatura.setAbreviatura(asignaturaDto.getAbreviatura());
            asignatura.setNivel(asignaturaDto.getNivel());
            asignatura.setGrupo(optional.get());
            Asignatura asignaturaGuardada = asignaturaService.save(asignatura);
            return ResponseEntity.created(URI.create("/api/asignaturas/" + asignaturaGuardada.getId()))
                    .body(ParserUtils.asignaturaToSimpleResponseDto(asignaturaGuardada));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> update(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        if (asignaturaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        asignatura.setId(id);
        return ResponseEntity.ok(asignaturaService.save(asignatura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (asignaturaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        asignaturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/


}