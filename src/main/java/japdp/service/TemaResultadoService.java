package japdp.service;

import japdp.model.Grupo;
import japdp.model.TemaResultado;
import japdp.model.TemaResultadoId;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles
 * para la gestión de las relaciones entre temas y resultados.
 */
public interface TemaResultadoService {

    /**
     * Obtiene todas las relaciones entre temas y resultados.
     *
     * @return Lista de relaciones
     */
    List<TemaResultado> findAll();

    /**
     * Obtiene una relación por su identificador compuesto.
     *
     * @param temaResultadoId Identificador compuesto de la relación
     * @return Relación encontrada, si existe
     */
    Optional<TemaResultado> findById(TemaResultadoId temaResultadoId);

    /**
     * Guarda una relación entre tema y resultado.
     *
     * @param temaResultado Relación a guardar
     * @return Relación guardada
     */
    TemaResultado save(TemaResultado temaResultado);

    /**
     * Guarda una lista de relaciones entre temas y resultados.
     *
     * @param temasResultados Lista de relaciones a guardar
     * @return Lista de relaciones guardadas
     */
    List<TemaResultado> saveAll(List<TemaResultado> temasResultados);

    /**
     * Elimina una relación por su identificador compuesto.
     *
     * @param temaResultadoId Identificador compuesto de la relación
     */
    void deleteById(TemaResultadoId temaResultadoId);
}