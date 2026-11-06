package japdp.service;

import japdp.model.Respuesta;
import japdp.repository.RespuestaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de respuestas.
 * Gestiona las operaciones relacionadas con las respuestas.
 */
@Service
public class RespuestaServiceImpl implements RespuestaService {

    /**
     * Repositorio encargado del acceso a los datos de las respuestas.
     */
    private final RespuestaRepository respuestaRepository;

    /**
     * Constructor del servicio.
     *
     * @param respuestaRepository Repositorio de respuestas
     */
    public RespuestaServiceImpl(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    /**
     * Obtiene todas las respuestas.
     *
     * @return Lista de respuestas
     */
    @Override
    public List<Respuesta> findAll() {
        return respuestaRepository.findAll();
    }

    /**
     * Obtiene una respuesta por su identificador.
     *
     * @param id Identificador de la respuesta
     * @return Respuesta encontrada, si existe
     */
    @Override
    public Optional<Respuesta> findById(Long id) {
        return respuestaRepository.findById(id);
    }

    /**
     * Guarda una respuesta.
     *
     * @param respuesta Respuesta a guardar
     * @return Respuesta guardada
     */
    @Override
    public Respuesta save(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    /**
     * Elimina una respuesta por su identificador.
     *
     * @param id Identificador de la respuesta
     */
    @Override
    public void deleteById(Long id) {
        respuestaRepository.deleteById(id);
    }
}