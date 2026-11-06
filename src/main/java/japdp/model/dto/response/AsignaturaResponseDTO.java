package japdp.model.dto.response;

import java.util.List;

public class AsignaturaResponseDTO {

    private Long asignaturaId;
    private String nombre;
    private String abreviatura;
    private String nivel;

    private List<TemaResumenResponseDTO> temas;
    private List<ResultadoResumenResponseDTO> resultados;

    public AsignaturaResponseDTO() {
    }

    public AsignaturaResponseDTO(
            Long asignaturaId,
            String nombre,
            String abreviatura,
            String nivel,
            List<TemaResumenResponseDTO> temas,
            List<ResultadoResumenResponseDTO> resultados
    ) {
        this.asignaturaId = asignaturaId;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.nivel = nivel;
        this.temas = temas;
        this.resultados = resultados;
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

    public List<TemaResumenResponseDTO> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaResumenResponseDTO> temas) {
        this.temas = temas;
    }

    public List<ResultadoResumenResponseDTO> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoResumenResponseDTO> resultados) {
        this.resultados = resultados;
    }
}