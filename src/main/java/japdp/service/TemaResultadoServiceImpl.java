package japdp.service;

import japdp.model.Grupo;
import japdp.model.TemaResultado;
import japdp.model.TemaResultadoId;
import japdp.repository.TemaResultadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de relaciones entre temas y resultados.
 * Gestiona las operaciones relacionadas con las relaciones tema-resultado.
 */
@Service
public class TemaResultadoServiceImpl implements TemaResultadoService {

    /**
     * Repositorio encargado del acceso a los datos de las relaciones tema-resultado.
     */
    private final TemaResultadoRepository temaResultadoRepository;

    /**
     * Constructor del servicio.
     *
     * @param temaResultadoRepository Repositorio de relaciones tema-resultado
     */
    public TemaResultadoServiceImpl(TemaResultadoRepository temaResultadoRepository) {
        this.temaResultadoRepository = temaResultadoRepository;
    }

    /**
     * Obtiene todas las relaciones entre temas y resultados.
     *
     * @return Lista de relaciones
     */
    @Override
    public List<TemaResultado> findAll() {
        return temaResultadoRepository.findAll();
    }

    /**
     * Obtiene una relación por su identificador compuesto.
     *
     * @param temaResultadoId Identificador compuesto de la relación
     * @return Relación encontrada, si existe
     */
    @Override
    public Optional<TemaResultado> findById(TemaResultadoId temaResultadoId) {
        return temaResultadoRepository.findById(temaResultadoId);
    }

    /**
     * Guarda una relación entre tema y resultado.
     *
     * @param temaResultado Relación a guardar
     * @return Relación guardada
     */
    @Override
    public TemaResultado save(TemaResultado temaResultado) {
        return temaResultadoRepository.save(temaResultado);
    }

    /**
     * Guarda una lista de relaciones entre temas y resultados.
     *
     * @param temasResultados Lista de relaciones a guardar
     * @return Lista de relaciones guardadas
     */
    @Override
    public List<TemaResultado> saveAll(List<TemaResultado> temasResultados) {
        return temaResultadoRepository.saveAll(temasResultados);
    }

    /**
     * Elimina una relación por su identificador compuesto.
     *
     * @param temaResultadoId Identificador compuesto de la relación
     */
    @Override
    public void deleteById(TemaResultadoId temaResultadoId) {
        temaResultadoRepository.deleteById(temaResultadoId);
    }
}