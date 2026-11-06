package japdp.model.dto.response;

public class TemaResponseDTO {

    private Long temaId;
    private String nombre;
    private AsignaturaResumenResponseDTO asignatura;

    public TemaResponseDTO() {
    }

    public TemaResponseDTO(
            Long temaId,
            String nombre,
            AsignaturaResumenResponseDTO asignatura
    ) {
        this.temaId = temaId;
        this.nombre = nombre;
        this.asignatura = asignatura;
    }

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AsignaturaResumenResponseDTO getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturaResumenResponseDTO asignatura) {
        this.asignatura = asignatura;
    }
}