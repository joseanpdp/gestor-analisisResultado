package japdp.repository;

import japdp.model.TemaResultado;
import japdp.model.TemaResultadoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaResultadoRepository extends JpaRepository<TemaResultado, TemaResultadoId> {

}
