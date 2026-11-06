package japdp.service;

import japdp.model.Tema;

import java.util.List;
import java.util.Optional;

public interface TemaService {

    List<Tema> findAll();

    Optional<Tema> findById(Long id);

    Tema save(Tema tema);

    void deleteById(Long id);

    List<Tema> findTemasByAsignaturaId(Long asignaturaId);
}