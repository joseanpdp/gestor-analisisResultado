package japdp.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un usuario del sistema.
 * Se corresponde con una tabla en la base de datos.
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    /**
     * Identificador único del usuario (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long usuarioId;

    /**
     * Nombre de usuario para iniciar sesión.
     */
    String username;

    /**
     * Contraseña del usuario (debería almacenarse cifrada).
     */
    String password;

    /**
     * Docente asociado al usuario.
     * Relación uno a uno: cada usuario puede tener un docente asociado.
     *
     * mappedBy indica que la entidad Docente es la propietaria de la relación.
     */
    @OneToOne(mappedBy = "usuario")
    Docente docente;

    /**
     * Rol del usuario dentro del sistema.
     * Se almacena como texto en la base de datos.
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Usuario() {
    }

    /**
     * Constructor completo del usuario.
     *
     * @param usuarioId Identificador único
     * @param username Nombre de usuario
     * @param password Contraseña del usuario
     * @param docente Docente asociado
     * @param role Rol del usuario
     */
    public Usuario(Long usuarioId, String username, String password, Docente docente, Role role) {
        this.usuarioId = usuarioId;
        this.username = username;
        this.password = password;
        this.docente = docente;
        this.role = role;
    }

    /**
     * @return Identificador del usuario
     */
    public Long getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId Nuevo identificador del usuario
     */
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * @return Nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username Nuevo nombre de usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password Nueva contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Docente asociado al usuario
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * @param docente Nuevo docente asociado al usuario
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * @return Rol del usuario
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role Nuevo rol del usuario
     */
    public void setRole(Role role) {
        this.role = role;
    }
}