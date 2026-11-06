package japdp.repository;

import japdp.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositorio encargado del acceso a los datos de los grupos.
 * Proporciona operaciones básicas de CRUD para la entidad Grupo.
 */
@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}