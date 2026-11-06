package japdp.repository;

import japdp.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio encargado del acceso a los datos de los temas.
 * Proporciona operaciones básicas de CRUD y consultas personalizadas
 * para la entidad Tema.
 */
@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

    /**
     * Obtiene los temas asociados a una asignatura.
     *
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de temas asociados a la asignatura
     */
    @Query("""
        SELECT t
            FROM Tema t
            WHERE t.asignatura.asignaturaId = :asignaturaId
    """)
    List<Tema> findTemasByAsignaturaId(@Param("asignaturaId") Long asignaturaId);
}