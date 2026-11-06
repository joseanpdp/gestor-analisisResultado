package japdp.service;

import japdp.model.Grupo;
import japdp.model.Respuesta;

import java.util.List;
import java.util.Optional;

public interface RespuestaService {
    List<Respuesta> findAll();

    Optional<Respuesta> findById(Long id);

    Respuesta save(Respuesta respuesta);

    void deleteById(Long id);
}
