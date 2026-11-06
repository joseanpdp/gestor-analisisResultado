package japdp.model.dto.response;

/**
 * DTO de respuesta que representa una asignatura de forma resumida.
 * Incluye únicamente los datos básicos de la asignatura.
 */
public class AsignaturaResumenResponseDTO {

    /**
     * Identificador único de la asignatura.
     */
    private Long asignaturaId;

    /**
     * Nombre de la asignatura.
     */
    private String nombre;

    /**
     * Abreviatura de la asignatura.
     */
    private String abreviatura;

    /**
     * Nivel educativo de la asignatura.
     */
    private String nivel;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public AsignaturaResumenResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param asignaturaId Identificador de la asignatura
     * @param nombre Nombre de la asignatura
     * @param abreviatura Abreviatura de la asignatura
     * @param nivel Nivel educativo
     */
    public AsignaturaResumenResponseDTO(
            Long asignaturaId,
            String nombre,
            String abreviatura,
            String nivel
    ) {
        this.asignaturaId = asignaturaId;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.nivel = nivel;
    }

    /**
     * @return Identificador de la asignatura
     */
    public Long getAsignaturaId() {
        return asignaturaId;
    }

    /**
     * @param asignaturaId Nuevo identificador de la asignatura
     */
    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    /**
     * @return Nombre de la asignatura
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre de la asignatura
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Abreviatura de la asignatura
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * @param abreviatura Nueva abreviatura de la asignatura
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * @return Nivel educativo de la asignatura
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel Nuevo nivel educativo
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}