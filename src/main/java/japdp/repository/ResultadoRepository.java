package japdp.repository;

import japdp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, ResultadoId> {
    /*
    SELECT a.*
        FROM ASIGNATURA_DOCENTE_GRUPO AS r
        JOIN ASIGNATURA AS a
            ON r.ASIGNATURA_ID = a.ASIGNATURA_ID;
    SELECT d.*
        FROM ASIGNATURA_DOCENTE_GRUPO AS r
        JOIN DOCENTE AS d
            ON r.DOCENTE_ID = d.DOCENTE_ID
        WHERE r.ASIGNATURA_ID = 1;
    SELECT g.*
        FROM ASIGNATURA_DOCENTE_GRUPO AS r
        JOIN GRUPO AS g
            ON r.GRUPO_ID = g.GRUPO_ID
        WHERE r.ASIGNATURA_ID = 1 AND
              r.DOCENTE_ID = 1;
    */

    @Query("""
        SELECT a
                FROM Resultado r
                JOIN r.asignatura a
                WHERE r.docente.docenteId = :docenteId
    """)
    List<Asignatura> findAsignaturasByDocenteId(@Param("docenteId") Long docenteId);

    @Query("""
        SELECT g
                FROM Resultado r
                JOIN r.grupo g
                WHERE r.docente.docenteId = :docenteId
                  AND r.asignatura.asignaturaId = :asignaturaId
    """)
    List<Grupo> findGruposByDocenteIdAndAsignaturaId(@Param("docenteId") Long docenteId, @Param("asignaturaId") Long asignaturaId);

    @Query("""
        SELECT r FROM Resultado r WHERE r.asignatura.asignaturaId = :asignaturaId
    """)
    List<Resultado> findByAsignaturaId(@Param("asignaturaId") Long asignaturaId);

    @Query("""
        SELECT r FROM Resultado r WHERE r.asignatura.asignaturaId = :asignaturaId AND r.grupo.grupoId = :grupoId
    """)
    Optional<Resultado> findByAsignaturaIdAndGrupoId(@Param("asignaturaId") Long asignaturaId, @Param("grupoId") Long grupoId);
}