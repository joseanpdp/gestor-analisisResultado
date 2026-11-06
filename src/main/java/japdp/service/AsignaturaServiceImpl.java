package japdp.service;

import japdp.model.Asignatura;
import japdp.repository.AsignaturaRepository;
import japdp.service.AsignaturaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de asignaturas.
 * Gestiona las operaciones relacionadas con las asignaturas.
 */
@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    /**
     * Repositorio encargado del acceso a los datos de las asignaturas.
     */
    private final AsignaturaRepository asignaturaRepository;

    /**
     * Constructor del servicio.
     *
     * @param asignaturaRepository Repositorio de asignaturas
     */
    public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    /**
     * Obtiene todas las asignaturas.
     *
     * @return Lista de asignaturas
     */
    @Override
    public List<Asignatura> findAll() {
        return asignaturaRepository.findAll();
    }

    /**
     * Obtiene una asignatura por su identificador.
     *
     * @param id Identificador de la asignatura
     * @return Asignatura encontrada, si existe
     */
    @Override
    public Optional<Asignatura> findById(Long id) {
        return asignaturaRepository.findById(id);
    }

    /**
     * Guarda una asignatura.
     *
     * @param asignatura Asignatura a guardar
     * @return Asignatura guardada
     */
    @Override
    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    /**
     * Elimina una asignatura por su identificador.
     *
     * @param id Identificador de la asignatura
     */
    @Override
    public void deleteById(Long id) {
        asignaturaRepository.deleteById(id);
    }
}