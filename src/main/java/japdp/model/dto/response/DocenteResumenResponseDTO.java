package japdp.model.dto.response;

import japdp.model.Role;

/**
 * DTO de respuesta que representa a un docente de forma resumida.
 * Incluye únicamente los datos básicos del docente.
 */
public class DocenteResumenResponseDTO {

    /**
     * Identificador único del docente.
     */
    private Long docenteId;

    /**
     * Nombre del docente.
     */
    private String nombre;

    /**
     * Rol del docente dentro del sistema.
     */
    private Role role;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public DocenteResumenResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param docenteId Identificador del docente
     * @param nombre Nombre del docente
     * @param role Rol del docente
     */
    public DocenteResumenResponseDTO(
            Long docenteId,
            String nombre,
            Role role
    ) {
        this.docenteId = docenteId;
        this.nombre = nombre;
        this.role = role;
    }

    /**
     * @return Identificador del docente
     */
    public Long getDocenteId() {
        return docenteId;
    }

    /**
     * @param docenteId Nuevo identificador del docente
     */
    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    /**
     * @return Nombre del docente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre del docente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Rol del docente
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role Nuevo rol del docente
     */
    public void setRole(Role role) {
        this.role = role;
    }
}