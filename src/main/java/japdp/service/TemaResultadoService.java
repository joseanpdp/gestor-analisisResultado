package japdp.service;

import japdp.model.Grupo;
import japdp.model.TemaResultado;
import japdp.model.TemaResultadoId;

import java.util.List;
import java.util.Optional;

public interface TemaResultadoService {
    List<TemaResultado> findAll();

    Optional<TemaResultado> findById(TemaResultadoId temaResultadoId);

    TemaResultado save(TemaResultado temaResultado);

    List<TemaResultado> saveAll(List<TemaResultado> temasResultados);

    void deleteById(TemaResultadoId temaResultadoId);

}
