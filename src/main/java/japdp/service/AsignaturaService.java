package japdp.service;

import japdp.model.Asignatura;

import java.util.List;
import java.util.Optional;

public interface AsignaturaService {

    List<Asignatura> findAll();

    Optional<Asignatura> findById(Long id);

    Asignatura save(Asignatura asignatura);

    void deleteById(Long id);
}