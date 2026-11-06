package japdp.repository;

import japdp.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio encargado del acceso a los datos de las asignaturas.
 * Proporciona operaciones básicas de CRUD para la entidad Asignatura.
 */
@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

}