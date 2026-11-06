package japdp.model.dto.request;

/**
 * Data Transfer Object (DTO) utilizado para gestionar la solicitud
 * de cambio de contraseña de un usuario.
 *
 * Contiene los datos necesarios para validar y aplicar el cambio.
 */
public class PasswordDTO {

    /**
     * Nombre de usuario del usuario que solicita el cambio de contraseña.
     */
    private String username;

    /**
     * Contraseña actual del docente (para validación).
     */
    private String passwordActual;

    /**
     * Nueva contraseña que se desea establecer.
     */
    private String password;

    /**
     * Confirmación de la nueva contraseña.
     * Debe coincidir con el campo 'password'.
     */
    private String confirmacion;

    /**
     * Constructor vacío.
     */
    public PasswordDTO() {
    }

    /**
     * Constructor completo.
     *
     * @param username Nombre de usuario del usuario
     * @param passwordActual Contraseña actual
     * @param password Nueva contraseña
     * @param confirmacion Confirmación de la nueva contraseña
     */
    public PasswordDTO(String username, String passwordActual, String password, String confirmacion) {
        this.username = username;
        this.passwordActual = passwordActual;
        this.password = password;
        this.confirmacion = confirmacion;
    }

    /**
     * @return Nombre de usuario del usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username Nuevo nombre de usuario del usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Contraseña actual
     */
    public String getPasswordActual() {
        return passwordActual;
    }

    /**
     * @param passwordActual Nueva contraseña actual (para validación)
     */
    public void setPasswordActual(String passwordActual) {
        this.passwordActual = passwordActual;
    }

    /**
     * @return Nueva contraseña
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password Nueva contraseña a establecer
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Confirmación de la nueva contraseña
     */
    public String getConfirmacion() {
        return confirmacion;
    }

    /**
     * @param confirmacion Nueva confirmación de contraseña
     */
    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }
}