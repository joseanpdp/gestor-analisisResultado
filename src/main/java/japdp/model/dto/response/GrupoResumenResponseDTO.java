package japdp.model.dto.response;

public class GrupoResumenResponseDTO {

    private Long grupoId;
    private String nombre;

    public GrupoResumenResponseDTO() {
    }

    public GrupoResumenResponseDTO(
            Long grupoId,
            String nombre
    ) {
        this.grupoId = grupoId;
        this.nombre = nombre;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}