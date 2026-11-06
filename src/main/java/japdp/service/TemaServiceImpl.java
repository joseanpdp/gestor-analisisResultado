package japdp.service;

import japdp.model.Tema;
import japdp.repository.TemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaServiceImpl implements TemaService {

    private final TemaRepository temaRepository;

    public TemaServiceImpl(TemaRepository temaRepository) {
        this.temaRepository = temaRepository;
    }

    @Override
    public List<Tema> findAll() {
        return temaRepository.findAll();
    }

    @Override
    public Optional<Tema> findById(Long id) {
        return temaRepository.findById(id);
    }

    @Override
    public Tema save(Tema tema) {
        return temaRepository.save(tema);
    }

    @Override
    public void deleteById(Long id) {
        temaRepository.deleteById(id);
    }

    @Override
    public List<Tema> findTemasByAsignaturaId(Long asignaturaId) {
        return temaRepository.findTemasByAsignaturaId(asignaturaId);
    }
}