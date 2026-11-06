package japdp.repository;

import japdp.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio encargado del acceso a los datos de los docentes.
 * Proporciona operaciones básicas de CRUD para la entidad Docente.
 */
@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
}