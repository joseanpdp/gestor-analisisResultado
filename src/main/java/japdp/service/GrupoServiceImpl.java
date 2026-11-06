package japdp.service;

import japdp.model.Grupo;
import japdp.repository.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de grupos.
 * Gestiona las operaciones relacionadas con los grupos.
 */
@Service
public class GrupoServiceImpl implements GrupoService {

    /**
     * Repositorio encargado del acceso a los datos de los grupos.
     */
    private final GrupoRepository grupoRepository;

    /**
     * Constructor del servicio.
     *
     * @param grupoRepository Repositorio de grupos
     */
    public GrupoServiceImpl(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    /**
     * Obtiene todos los grupos.
     *
     * @return Lista de grupos
     */
    @Override
    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    /**
     * Obtiene un grupo por su identificador.
     *
     * @param id Identificador del grupo
     * @return Grupo encontrado, si existe
     */
    @Override
    public Optional<Grupo> findById(Long id) {
        return grupoRepository.findById(id);
    }

    /**
     * Guarda un grupo.
     *
     * @param grupo Grupo a guardar
     * @return Grupo guardado
     */
    @Override
    public Grupo save(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    /**
     * Elimina un grupo por su identificador.
     *
     * @param id Identificador del grupo
     */
    @Override
    public void deleteById(Long id) {
        grupoRepository.deleteById(id);
    }
}