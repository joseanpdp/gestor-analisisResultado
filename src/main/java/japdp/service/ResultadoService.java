package japdp.service;

import japdp.model.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResultadoService {
    List<Resultado> findAll();

    Optional<Resultado> findById(ResultadoId id);

    Resultado save(Resultado resultado);

    void deleteById(ResultadoId id);

    List<Asignatura> findAsignaturasByDocenteId(Long docenteId);
    List<Grupo> findGruposByDocenteIdAndAsignaturaId(Long docenteId, Long asignaturaId);

    List<Resultado> findResultadosByAsignaturaId(Long asignaturaId);

    Optional<Resultado> findResultadoByAsignaturaIdAndGrupoId(Long asignaturaId, Long grupoId);
}
