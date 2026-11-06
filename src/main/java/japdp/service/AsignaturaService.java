package japdp.service;

import japdp.model.Asignatura;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles
 * para la gestión de asignaturas.
 */
public interface AsignaturaService {

    /**
     * Obtiene todas las asignaturas.
     *
     * @return Lista de asignaturas
     */
    List<Asignatura> findAll();

    /**
     * Obtiene una asignatura por su identificador.
     *
     * @param id Identificador de la asignatura
     * @return Asignatura encontrada, si existe
     */
    Optional<Asignatura> findById(Long id);

    /**
     * Guarda una asignatura.
     *
     * @param asignatura Asignatura a guardar
     * @return Asignatura guardada
     */
    Asignatura save(Asignatura asignatura);

    /**
     * Elimina una asignatura por su identificador.
     *
     * @param id Identificador de la asignatura
     */
    void deleteById(Long id);
}