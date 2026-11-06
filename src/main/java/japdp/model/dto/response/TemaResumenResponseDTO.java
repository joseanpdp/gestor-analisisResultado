package japdp.model.dto.response;

public class TemaResumenResponseDTO {

    private Long temaId;
    private String nombre;

    public TemaResumenResponseDTO() {
    }

    public TemaResumenResponseDTO(
            Long temaId,
            String nombre
    ) {
        this.temaId = temaId;
        this.nombre = nombre;
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
}