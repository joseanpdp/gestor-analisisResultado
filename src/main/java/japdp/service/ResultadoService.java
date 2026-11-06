package japdp.service;

import japdp.model.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles
 * para la gestión de resultados.
 */
public interface ResultadoService {

    /**
     * Obtiene todos los resultados.
     *
     * @return Lista de resultados
     */
    List<Resultado> findAll();

    /**
     * Obtiene un resultado por su identificador compuesto.
     *
     * @param id Identificador compuesto del resultado
     * @return Resultado encontrado, si existe
     */
    Optional<Resultado> findById(ResultadoId id);

    /**
     * Guarda un resultado.
     *
     * @param resultado Resultado a guardar
     * @return Resultado guardado
     */
    Resultado save(Resultado resultado);

    /**
     * Elimina un resultado por su identificador compuesto.
     *
     * @param id Identificador compuesto del resultado
     */
    void deleteById(ResultadoId id);

    /**
     * Obtiene las asignaturas asociadas a un docente.
     *
     * @param docenteId Identificador del docente
     * @return Lista de asignaturas asociadas
     */
    List<Asignatura> findAsignaturasByDocenteId(Long docenteId);

    /**
     * Obtiene los grupos asociados a un docente y una asignatura.
     *
     * @param docenteId Identificador del docente
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de grupos asociados
     */
    List<Grupo> findGruposByDocenteIdAndAsignaturaId(Long docenteId, Long asignaturaId);

    /**
     * Obtiene los resultados asociados a una asignatura.
     *
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de resultados asociados
     */
    List<Resultado> findResultadosByAsignaturaId(Long asignaturaId);

    /**
     * Obtiene un resultado por asignatura y grupo.
     *
     * @param asignaturaId Identificador de la asignatura
     * @param grupoId Identificador del grupo
     * @return Resultado encontrado, si existe
     */
    Optional<Resultado> findResultadoByAsignaturaIdAndGrupoId(Long asignaturaId, Long grupoId);
}