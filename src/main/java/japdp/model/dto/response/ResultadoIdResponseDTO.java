package japdp.model.dto.response;

/**
 * DTO de respuesta que representa el identificador compuesto
 * de un resultado académico.
 */
public class ResultadoIdResponseDTO {

    /**
     * Identificador de la asignatura.
     */
    private Long asignaturaId;

    /**
     * Identificador del docente.
     */
    private Long docenteId;

    /**
     * Identificador del grupo.
     */
    private Long grupoId;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public ResultadoIdResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param asignaturaId Identificador de la asignatura
     * @param docenteId Identificador del docente
     * @param grupoId Identificador del grupo
     */
    public ResultadoIdResponseDTO(
            Long asignaturaId,
            Long docenteId,
            Long grupoId
    ) {
        this.asignaturaId = asignaturaId;
        this.docenteId = docenteId;
        this.grupoId = grupoId;
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
}