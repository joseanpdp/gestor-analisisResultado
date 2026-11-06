package japdp.service;

import japdp.model.Tema;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles
 * para la gestión de temas.
 */
public interface TemaService {

    /**
     * Obtiene todos los temas.
     *
     * @return Lista de temas
     */
    List<Tema> findAll();

    /**
     * Obtiene un tema por su identificador.
     *
     * @param id Identificador del tema
     * @return Tema encontrado, si existe
     */
    Optional<Tema> findById(Long id);

    /**
     * Guarda un tema.
     *
     * @param tema Tema a guardar
     * @return Tema guardado
     */
    Tema save(Tema tema);

    /**
     * Elimina un tema por su identificador.
     *
     * @param id Identificador del tema
     */
    void deleteById(Long id);

    /**
     * Obtiene los temas asociados a una asignatura.
     *
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de temas asociados
     */
    List<Tema> findTemasByAsignaturaId(Long asignaturaId);
}