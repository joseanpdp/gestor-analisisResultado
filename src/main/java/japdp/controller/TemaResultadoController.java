package japdp.controller;

import japdp.ParserUtils;
import japdp.model.TemaResultado;
import japdp.model.dto.response.TemaResultadoResponseDTO;
import japdp.service.TemaResultadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/temaresul")
@CrossOrigin(origins = "http://localhost:5500")
public class TemaResultadoController {

    private final TemaResultadoService temaResultadoService;

    public TemaResultadoController(TemaResultadoService temaResultadoService) {
        this.temaResultadoService = temaResultadoService;
    }

    @GetMapping
    public ResponseEntity<List<TemaResultadoResponseDTO>> findAll() {
        List<TemaResultado> temasResultados = temaResultadoService.findAll();
        List<TemaResultadoResponseDTO> temaResultadoDtos = new ArrayList<>();
        for (TemaResultado temaResultado : temasResultados) {
            TemaResultadoResponseDTO temaResultadoDto = ParserUtils.temaResultadoToResponseDto(temaResultado);
            temaResultadoDtos.add(temaResultadoDto);
        }
        return ResponseEntity.ok(temaResultadoDtos);
    }
}
