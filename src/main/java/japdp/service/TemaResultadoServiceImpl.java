package japdp.service;

import japdp.model.Grupo;
import japdp.model.TemaResultado;
import japdp.model.TemaResultadoId;
import japdp.repository.TemaResultadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaResultadoServiceImpl implements TemaResultadoService {
    private final TemaResultadoRepository temaResultadoRepository;

    public TemaResultadoServiceImpl(TemaResultadoRepository temaResultadoRepository) {
        this.temaResultadoRepository = temaResultadoRepository;
    }

    @Override
    public List<TemaResultado> findAll() {
        return temaResultadoRepository.findAll();
    }

    @Override
    public Optional<TemaResultado> findById(TemaResultadoId temaResultadoId) {
        return temaResultadoRepository.findById(temaResultadoId);
    }

    @Override
    public TemaResultado save(TemaResultado temaResultado) {
        return temaResultadoRepository.save(temaResultado);
    }

    @Override
    public List<TemaResultado> saveAll(List<TemaResultado> temasResultados) {
        return temaResultadoRepository.saveAll(temasResultados);
    }

    @Override
    public void deleteById(TemaResultadoId temaResultadoId) {
        temaResultadoRepository.deleteById(temaResultadoId);
    }
}
