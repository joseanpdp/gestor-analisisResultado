package japdp.service;

import japdp.model.Usuario;
import japdp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de usuarios.
 * Gestiona las operaciones relacionadas con los usuarios.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    /**
     * Repositorio encargado del acceso a los datos de los usuarios.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Constructor del servicio.
     *
     * @param usuarioRepository Repositorio de usuarios
     */
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de usuarios
     */
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    /**
     * Obtiene un usuario por su identificador.
     *
     * @param id Identificador del usuario
     * @return Usuario encontrado, si existe
     */
    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Obtiene un usuario por su nombre de usuario.
     *
     * @param username Nombre de usuario
     * @return Usuario encontrado, si existe
     */
    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    /**
     * Guarda un usuario.
     *
     * @param usuario Usuario a guardar
     * @return Usuario guardado
     */
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Elimina un usuario por su identificador.
     *
     * @param id Identificador del usuario
     */
    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}