package japdp.service;

import japdp.model.Grupo;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles
 * para la gestión de grupos.
 */
public interface GrupoService {

    /**
     * Obtiene todos los grupos.
     *
     * @return Lista de grupos
     */
    List<Grupo> findAll();

    /**
     * Obtiene un grupo por su identificador.
     *
     * @param id Identificador del grupo
     * @return Grupo encontrado, si existe
     */
    Optional<Grupo> findById(Long id);

    /**
     * Guarda un grupo.
     *
     * @param grupo Grupo a guardar
     * @return Grupo guardado
     */
    Grupo save(Grupo grupo);

    /**
     * Elimina un grupo por su identificador.
     *
     * @param id Identificador del grupo
     */
    void deleteById(Long id);
}