package japdp.service;

import japdp.model.Docente;

import java.util.List;
import java.util.Optional;

public interface DocenteService {

    List<Docente> findAll();

    Optional<Docente> findById(Long id);

    Docente save(Docente docente);

    void deleteById(Long id);
}