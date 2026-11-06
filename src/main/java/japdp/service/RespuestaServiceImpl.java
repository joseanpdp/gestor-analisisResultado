package japdp.service;

import japdp.model.Respuesta;
import japdp.repository.RespuestaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaServiceImpl implements RespuestaService {
    private final RespuestaRepository respuestaRepository;

    public RespuestaServiceImpl(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    @Override
    public List<Respuesta> findAll() {
        return respuestaRepository.findAll();
    }

    @Override
    public Optional<Respuesta> findById(Long id) {
        return respuestaRepository.findById(id);
    }

    @Override
    public Respuesta save(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    @Override
    public void deleteById(Long id) {
        respuestaRepository.deleteById(id);
    }
}
