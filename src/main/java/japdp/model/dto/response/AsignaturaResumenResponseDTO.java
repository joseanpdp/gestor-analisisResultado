package japdp.model.dto.response;

public class AsignaturaResumenResponseDTO {

    private Long asignaturaId;
    private String nombre;
    private String abreviatura;
    private String nivel;

    public AsignaturaResumenResponseDTO() {
    }

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

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}