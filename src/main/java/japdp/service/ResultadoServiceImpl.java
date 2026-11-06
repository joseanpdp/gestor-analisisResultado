package japdp.service;

import japdp.model.*;
import japdp.repository.ResultadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoServiceImpl implements ResultadoService {
    private final ResultadoRepository resultadoRepository;

    public ResultadoServiceImpl(ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    @Override
    public List<Resultado> findAll() {
        return resultadoRepository.findAll();
    }

    @Override
    public Optional<Resultado> findById(ResultadoId id) {
        return resultadoRepository.findById(id);
    }

    @Override
    public Resultado save(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    @Override
    public void deleteById(ResultadoId id) {
        resultadoRepository.deleteById(id);
    }

    @Override
    public List<Asignatura> findAsignaturasByDocenteId(Long docenteId) {
        return resultadoRepository.findAsignaturasByDocenteId(docenteId);
    }

    @Override
    public List<Grupo> findGruposByDocenteIdAndAsignaturaId(Long docenteId, Long asignaturaId) {
        return resultadoRepository.findGruposByDocenteIdAndAsignaturaId(docenteId, asignaturaId);
    }

    /*@Override
    public List<Grupo> findGruposByAsignaturaId(Long asignaturaId) {
        return resultadoRepository.findGruposByAsignaturaId(asignaturaId);
    }*/

    @Override
    public List<Resultado> findResultadosByAsignaturaId(Long asignaturaId) {
        return resultadoRepository.findByAsignaturaId(asignaturaId);
    }

    @Override
    public Optional<Resultado> findResultadoByAsignaturaIdAndGrupoId(Long asignaturaId, Long grupoId) {
        return resultadoRepository.findByAsignaturaIdAndGrupoId(asignaturaId, grupoId);
    }
}
