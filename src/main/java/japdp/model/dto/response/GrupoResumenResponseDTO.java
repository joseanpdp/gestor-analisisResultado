package japdp.model.dto.response;

/**
 * DTO de respuesta que representa un grupo de forma resumida.
 * Incluye únicamente los datos básicos del grupo.
 */
public class GrupoResumenResponseDTO {

    /**
     * Identificador único del grupo.
     */
    private Long grupoId;

    /**
     * Nombre del grupo.
     */
    private String nombre;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public GrupoResumenResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param grupoId Identificador del grupo
     * @param nombre Nombre del grupo
     */
    public GrupoResumenResponseDTO(
            Long grupoId,
            String nombre
    ) {
        this.grupoId = grupoId;
        this.nombre = nombre;
    }

    /**
     * @return Identificador del grupo
     */
    public Long getGrupoId() {
        return grupoId;
    }

    /**
     * @param grupoId Nuevo identificador del grupo
     */
    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    /**
     * @return Nombre del grupo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre del grupo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}