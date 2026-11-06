package japdp.service;

import japdp.model.Docente;
import japdp.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de docentes.
 * Gestiona las operaciones relacionadas con los docentes.
 */
@Service
public class DocenteServiceImpl implements DocenteService {

    /**
     * Repositorio encargado del acceso a los datos de los docentes.
     */
    private final DocenteRepository docenteRepository;

    /**
     * Constructor del servicio.
     *
     * @param docenteRepository Repositorio de docentes
     */
    public DocenteServiceImpl(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    /**
     * Obtiene todos los docentes.
     *
     * @return Lista de docentes
     */
    @Override
    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    /**
     * Obtiene un docente por su identificador.
     *
     * @param id Identificador del docente
     * @return Docente encontrado, si existe
     */
    @Override
    public Optional<Docente> findById(Long id) {
        return docenteRepository.findById(id);
    }

    /**
     * Guarda un docente.
     *
     * @param docente Docente a guardar
     * @return Docente guardado
     */
    @Override
    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    /**
     * Elimina un docente por su identificador.
     *
     * @param id Identificador del docente
     */
    @Override
    public void deleteById(Long id) {
        docenteRepository.deleteById(id);
    }
}