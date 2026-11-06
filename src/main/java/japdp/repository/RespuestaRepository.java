package japdp.repository;

import japdp.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

}
