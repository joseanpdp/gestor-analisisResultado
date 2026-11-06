package japdp.service;

import japdp.model.Grupo;

import java.util.List;
import java.util.Optional;

public interface GrupoService {

    List<Grupo> findAll();

    Optional<Grupo> findById(Long id);

    Grupo save(Grupo grupo);

    void deleteById(Long id);
}