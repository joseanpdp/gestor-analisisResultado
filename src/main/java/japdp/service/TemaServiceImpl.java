package japdp.service;

import japdp.model.Tema;
import japdp.repository.TemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de temas.
 * Gestiona las operaciones relacionadas con los temas.
 */
@Service
public class TemaServiceImpl implements TemaService {

    /**
     * Repositorio encargado del acceso a los datos de los temas.
     */
    private final TemaRepository temaRepository;

    /**
     * Constructor del servicio.
     *
     * @param temaRepository Repositorio de temas
     */
    public TemaServiceImpl(TemaRepository temaRepository) {
        this.temaRepository = temaRepository;
    }

    /**
     * Obtiene todos los temas.
     *
     * @return Lista de temas
     */
    @Override
    public List<Tema> findAll() {
        return temaRepository.findAll();
    }

    /**
     * Obtiene un tema por su identificador.
     *
     * @param id Identificador del tema
     * @return Tema encontrado, si existe
     */
    @Override
    public Optional<Tema> findById(Long id) {
        return temaRepository.findById(id);
    }

    /**
     * Guarda un tema.
     *
     * @param tema Tema a guardar
     * @return Tema guardado
     */
    @Override
    public Tema save(Tema tema) {
        return temaRepository.save(tema);
    }

    /**
     * Elimina un tema por su identificador.
     *
     * @param id Identificador del tema
     */
    @Override
    public void deleteById(Long id) {
        temaRepository.deleteById(id);
    }

    /**
     * Obtiene los temas asociados a una asignatura.
     *
     * @param asignaturaId Identificador de la asignatura
     * @return Lista de temas asociados
     */
    @Override
    public List<Tema> findTemasByAsignaturaId(Long asignaturaId) {
        return temaRepository.findTemasByAsignaturaId(asignaturaId);
    }
}