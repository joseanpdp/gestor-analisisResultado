package japdp.controller;

import japdp.ParserUtils;
import japdp.model.Respuesta;
import japdp.model.dto.response.RespuestaResponseDTO;
import japdp.service.RespuestaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
@CrossOrigin(origins = "http://localhost:5500")
public class RespuestaController {
    private final RespuestaService respuestaService;

    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @GetMapping
    public ResponseEntity<List<RespuestaResponseDTO>> findAll() {
        List<Respuesta> respuestas = respuestaService.findAll();
        List<RespuestaResponseDTO> respuestaDtos = new ArrayList<>();
        for (Respuesta respuesta : respuestas) {
            RespuestaResponseDTO respuestaDto = ParserUtils.respuestaToResponseDto(respuesta);
            respuestaDtos.add(respuestaDto);
        }

        return ResponseEntity.ok(respuestaDtos);
    }
}
