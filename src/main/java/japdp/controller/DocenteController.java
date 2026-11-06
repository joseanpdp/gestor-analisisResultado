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

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "http://localhost:5500")
public class DocenteController {

    private final DocenteService docenteService;
    private final AsignaturaService asignaturaService;

    public DocenteController(DocenteService docenteService, AsignaturaService asignaturaService) {
        this.docenteService = docenteService;
        this.asignaturaService = asignaturaService;
    }

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

    /*@PostMapping
    public ResponseEntity<DocenteSimpleResponseDTO> save(@RequestBody DocenteRequestDTO docenteDto) {
        Docente docente = new Docente();
        docente.setNombre(docenteDto.getNombre());
        Docente docenteGuardado = docenteService.save(docente);
        return ResponseEntity
                .created(URI.create("/api/docentes/" + docenteGuardado.getId()))
                .body(ParserUtils.docenteToSimpleResponseDto(docenteGuardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Docente> update(
            @PathVariable Long id,
            @RequestBody Docente docente
    ) {
        if (docenteService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        docente.setId(id);

        return ResponseEntity.ok(docenteService.save(docente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (docenteService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        docenteService.deleteById(id);

        return ResponseEntity.noContent().build();
    }*/
}