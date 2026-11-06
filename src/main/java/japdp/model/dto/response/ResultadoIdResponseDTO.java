package japdp.model.dto.response;

public class ResultadoIdResponseDTO {

    private Long asignaturaId;
    private Long docenteId;
    private Long grupoId;

    public ResultadoIdResponseDTO() {
    }

    public ResultadoIdResponseDTO(
            Long asignaturaId,
            Long docenteId,
            Long grupoId
    ) {
        this.asignaturaId = asignaturaId;
        this.docenteId = docenteId;
        this.grupoId = grupoId;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }
}