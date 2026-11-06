package japdp.repository;

import japdp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio encargado del acceso a los datos de los resultados.
 * Proporciona operaciones básicas de CRUD y consultas personalizadas
 * para la entidad Resultado.
 */
@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, ResultadoId> {

    /**
     * Obtiene las asignaturas asociadas a un docente.
     *
     * @param docenteId Identificador del docente
     * @return Lista de asignaturas asociadas al docente
     */
    @Query("""
        SELECT a
                FROM Resultado r
                JOIN r.asignatura a
                WHERE r.docente.docenteId = :docenteId
    """)
    List<Asignatura> findAsignaturasByDocenteId(@Param("docenteId") Long docenteId);

    /**
     * Obtiene los grupos asociados a un docente y una asignatura.
     *
     * @param docenteId Identificador del docente
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de grupos asociados
     */
    @Query("""
        SELECT g
                FROM Resultado r
                JOIN r.grupo g
                WHERE r.docente.docenteId = :docenteId
                  AND r.asignatura.asignaturaId = :asignaturaId
    """)
    List<Grupo> findGruposByDocenteIdAndAsignaturaId(@Param("docenteId") Long docenteId, @Param("asignaturaId") Long asignaturaId);

    /**
     * Obtiene los resultados asociados a una asignatura.
     *
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de resultados asociados a la asignatura
     */
    @Query("""
        SELECT r FROM Resultado r WHERE r.asignatura.asignaturaId = :asignaturaId
    """)
    List<Resultado> findByAsignaturaId(@Param("asignaturaId") Long asignaturaId);

    /**
     * Obtiene un resultado por asignatura y grupo.
     *
     * @param asignaturaId Identificador de la asignatura
     * @param grupoId Identificador del grupo
     * @return Resultado encontrado, si existe
     */
    @Query("""
        SELECT r FROM Resultado r WHERE r.asignatura.asignaturaId = :asignaturaId AND r.grupo.grupoId = :grupoId
    """)
    Optional<Resultado> findByAsignaturaIdAndGrupoId(@Param("asignaturaId") Long asignaturaId, @Param("grupoId") Long grupoId);
}