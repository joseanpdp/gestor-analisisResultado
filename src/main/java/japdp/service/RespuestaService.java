package japdp.service;

import japdp.model.Grupo;
import japdp.model.Respuesta;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles
 * para la gestión de respuestas.
 */
public interface RespuestaService {

    /**
     * Obtiene todas las respuestas.
     *
     * @return Lista de respuestas
     */
    List<Respuesta> findAll();

    /**
     * Obtiene una respuesta por su identificador.
     *
     * @param id Identificador de la respuesta
     * @return Respuesta encontrada, si existe
     */
    Optional<Respuesta> findById(Long id);

    /**
     * Guarda una respuesta.
     *
     * @param respuesta Respuesta a guardar
     * @return Respuesta guardada
     */
    Respuesta save(Respuesta respuesta);

    /**
     * Elimina una respuesta por su identificador.
     *
     * @param id Identificador de la respuesta
     */
    void deleteById(Long id);
}