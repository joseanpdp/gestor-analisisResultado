package japdp.model.dto.response;

/**
 * DTO de respuesta que representa un tema de forma resumida.
 * Incluye únicamente los datos básicos del tema.
 */
public class TemaResumenResponseDTO {

    /**
     * Identificador único del tema.
     */
    private Long temaId;

    /**
     * Nombre del tema.
     */
    private String nombre;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public TemaResumenResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param temaId Identificador del tema
     * @param nombre Nombre del tema
     */
    public TemaResumenResponseDTO(
            Long temaId,
            String nombre
    ) {
        this.temaId = temaId;
        this.nombre = nombre;
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
}