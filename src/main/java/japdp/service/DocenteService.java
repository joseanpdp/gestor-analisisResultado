package japdp.service;

import japdp.model.Docente;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles
 * para la gestión de docentes.
 */
public interface DocenteService {

    /**
     * Obtiene todos los docentes.
     *
     * @return Lista de docentes
     */
    List<Docente> findAll();

    /**
     * Obtiene un docente por su identificador.
     *
     * @param id Identificador del docente
     * @return Docente encontrado, si existe
     */
    Optional<Docente> findById(Long id);

    /**
     * Guarda un docente.
     *
     * @param docente Docente a guardar
     * @return Docente guardado
     */
    Docente save(Docente docente);

    /**
     * Elimina un docente por su identificador.
     *
     * @param id Identificador del docente
     */
    void deleteById(Long id);
}