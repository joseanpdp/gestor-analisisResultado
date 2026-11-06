package japdp.service;

import japdp.model.*;
import japdp.repository.ResultadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de resultados.
 * Gestiona las operaciones relacionadas con los resultados.
 */
@Service
public class ResultadoServiceImpl implements ResultadoService {

    /**
     * Repositorio encargado del acceso a los datos de los resultados.
     */
    private final ResultadoRepository resultadoRepository;

    /**
     * Constructor del servicio.
     *
     * @param resultadoRepository Repositorio de resultados
     */
    public ResultadoServiceImpl(ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    /**
     * Obtiene todos los resultados.
     *
     * @return Lista de resultados
     */
    @Override
    public List<Resultado> findAll() {
        return resultadoRepository.findAll();
    }

    /**
     * Obtiene un resultado por su identificador compuesto.
     *
     * @param id Identificador compuesto del resultado
     * @return Resultado encontrado, si existe
     */
    @Override
    public Optional<Resultado> findById(ResultadoId id) {
        return resultadoRepository.findById(id);
    }

    /**
     * Guarda un resultado.
     *
     * @param resultado Resultado a guardar
     * @return Resultado guardado
     */
    @Override
    public Resultado save(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    /**
     * Elimina un resultado por su identificador compuesto.
     *
     * @param id Identificador compuesto del resultado
     */
    @Override
    public void deleteById(ResultadoId id) {
        resultadoRepository.deleteById(id);
    }

    /**
     * Obtiene las asignaturas asociadas a un docente.
     *
     * @param docenteId Identificador del docente
     * @return Lista de asignaturas asociadas
     */
    @Override
    public List<Asignatura> findAsignaturasByDocenteId(Long docenteId) {
        return resultadoRepository.findAsignaturasByDocenteId(docenteId);
    }

    /**
     * Obtiene los grupos asociados a un docente y una asignatura.
     *
     * @param docenteId Identificador del docente
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de grupos asociados
     */
    @Override
    public List<Grupo> findGruposByDocenteIdAndAsignaturaId(Long docenteId, Long asignaturaId) {
        return resultadoRepository.findGruposByDocenteIdAndAsignaturaId(docenteId, asignaturaId);
    }

    /*@Override
    public List<Grupo> findGruposByAsignaturaId(Long asignaturaId) {
        return resultadoRepository.findGruposByAsignaturaId(asignaturaId);
    }*/

    /**
     * Obtiene los resultados asociados a una asignatura.
     *
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de resultados asociados
     */
    @Override
    public List<Resultado> findResultadosByAsignaturaId(Long asignaturaId) {
        return resultadoRepository.findByAsignaturaId(asignaturaId);
    }

    /**
     * Obtiene un resultado por asignatura y grupo.
     *
     * @param asignaturaId Identificador de la asignatura
     * @param grupoId Identificador del grupo
     * @return Resultado encontrado, si existe
     */
    @Override
    public Optional<Resultado> findResultadoByAsignaturaIdAndGrupoId(Long asignaturaId, Long grupoId) {
        return resultadoRepository.findByAsignaturaIdAndGrupoId(asignaturaId, grupoId);
    }
}