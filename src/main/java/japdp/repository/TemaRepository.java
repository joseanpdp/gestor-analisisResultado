package japdp.repository;

import japdp.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
    @Query("""
        SELECT t
            FROM Tema t
            WHERE t.asignatura.asignaturaId = :asignaturaId
    """)
    List<Tema> findTemasByAsignaturaId(@Param("asignaturaId") Long asignaturaId);
}