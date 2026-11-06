package japdp.service;

import japdp.model.Asignatura;
import japdp.model.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles
 * para la gestión de usuarios.
 */
public interface UsuarioService {

    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de usuarios
     */
    List<Usuario> findAll();

    /**
     * Obtiene un usuario por su identificador.
     *
     * @param id Identificador del usuario
     * @return Usuario encontrado, si existe
     */
    Optional<Usuario> findById(Long id);

    /**
     * Obtiene un usuario por su nombre de usuario.
     *
     * @param username Nombre de usuario
     * @return Usuario encontrado, si existe
     */
    Optional<Usuario> findByUsername(String username);

    /**
     * Guarda un usuario.
     *
     * @param usuario Usuario a guardar
     * @return Usuario guardado
     */
    Usuario save(Usuario usuario);

    /**
     * Elimina un usuario por su identificador.
     *
     * @param id Identificador del usuario
     */
    void deleteById(Long id);
}