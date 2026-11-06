package japdp.security;

import japdp.model.Docente;
import japdp.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Implementación de {@link UserDetails} que adapta la entidad
 * {@link Docente} al modelo de autenticación de Spring Security.
 *
 * Proporciona la información necesaria para que Spring Security
 * pueda autenticar y autorizar a un docente.
 */
public class SecurityUsuario implements UserDetails {

    /**
     * Docente asociado al usuario autenticado.
     */
    private final Usuario usuario;

    /**
     * Construye un nuevo objeto de seguridad a partir de un usuario.
     *
     * @param usuario Docente que se adaptará al modelo de Spring Security
     */
    public SecurityUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el nombre de usuario utilizado para la autenticación.
     *
     * @return Identificador del docente
     */
    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    /**
     * Obtiene la contraseña del docente.
     *
     * @return Contraseña del docente
     */
    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    /**
     * Obtiene los permisos o roles asociados al docente.
     *
     * @return Colección de autoridades del usuario
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRole().name()));
    }

    /**
     * Indica si la cuenta del usuario no ha expirado.
     *
     * @return {@code true}, ya que la aplicación no gestiona expiración de cuentas
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta del usuario no está bloqueada.
     *
     * @return {@code true}, ya que la aplicación no gestiona bloqueo de cuentas
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indica si las credenciales del usuario no han expirado.
     *
     * @return {@code true}, ya que la aplicación no gestiona expiración de credenciales
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta del usuario está habilitada.
     *
     * @return {@code true}, ya que la aplicación considera habilitados a todos los usuarios
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}