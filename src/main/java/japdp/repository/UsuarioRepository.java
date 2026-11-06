package japdp.repository;

import japdp.model.Asignatura;
import japdp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio encargado del acceso a los datos de los usuarios.
 * Proporciona operaciones básicas de CRUD y una consulta personalizada
 * para la entidad Usuario.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Obtiene un usuario por su nombre de usuario.
     *
     * @param username Nombre de usuario
     * @return Usuario encontrado, si existe
     */
    Optional<Usuario> findByUsername(String username);
}