package japdp.repository;

import japdp.model.TemaResultado;
import japdp.model.TemaResultadoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio encargado del acceso a los datos de las relaciones
 * entre temas y resultados.
 * Proporciona operaciones básicas de CRUD para la entidad TemaResultado.
 */
@Repository
public interface TemaResultadoRepository extends JpaRepository<TemaResultado, TemaResultadoId> {

}