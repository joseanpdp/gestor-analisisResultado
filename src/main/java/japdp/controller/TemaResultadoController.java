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

/**
 * Controlador REST que gestiona las operaciones relacionadas con las relaciones
 * entre temas y resultados.
 * Expone endpoints para consultar las relaciones registradas.
 */
@RestController
@RequestMapping("/api/temaresul")
@CrossOrigin(origins = "http://localhost:5500")
public class TemaResultadoController {

    /**
     * Servicio encargado de la lógica de negocio de las relaciones tema-resultado.
     */
    private final TemaResultadoService temaResultadoService;

    /**
     * Constructor del controlador.
     *
     * @param temaResultadoService Servicio de relaciones tema-resultado
     */
    public TemaResultadoController(TemaResultadoService temaResultadoService) {
        this.temaResultadoService = temaResultadoService;
    }

    /**
     * Obtiene todas las relaciones entre temas y resultados.
     *
     * @return Lista de relaciones en formato DTO
     */
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