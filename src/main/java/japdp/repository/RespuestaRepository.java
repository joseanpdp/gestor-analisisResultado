package japdp.repository;

import japdp.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Repositorio encargado del acceso a los datos de las respuestas.
 * Proporciona operaciones básicas de CRUD para la entidad Respuesta.
 */
@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

}