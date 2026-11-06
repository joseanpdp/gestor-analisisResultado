package japdp.model.dto.response;

/**
 * DTO de respuesta que representa un tema.
 * Incluye los datos básicos del tema y su asignatura asociada.
 */
public class TemaResponseDTO {

    /**
     * Identificador único del tema.
     */
    private Long temaId;

    /**
     * Nombre del tema.
     */
    private String nombre;

    /**
     * Asignatura asociada al tema.
     */
    private AsignaturaResumenResponseDTO asignatura;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public TemaResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param temaId Identificador del tema
     * @param nombre Nombre del tema
     * @param asignatura Asignatura asociada
     */
    public TemaResponseDTO(
            Long temaId,
            String nombre,
            AsignaturaResumenResponseDTO asignatura
    ) {
        this.temaId = temaId;
        this.nombre = nombre;
        this.asignatura = asignatura;
    }

    /**
     * @return Identificador del tema
     */
    public Long getTemaId() {
        return temaId;
    }

    /**
     * @param temaId Nuevo identificador del tema
     */
    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    /**
     * @return Nombre del tema
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre del tema
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Asignatura asociada al tema
     */
    public AsignaturaResumenResponseDTO getAsignatura() {
        return asignatura;
    }

    /**
     * @param asignatura Nueva asignatura asociada
     */
    public void setAsignatura(AsignaturaResumenResponseDTO asignatura) {
        this.asignatura = asignatura;
    }
}