package japdp.model.dto.response;

import japdp.model.dto.response.ResultadoResumenResponseDTO;

import java.util.List;

public class GrupoResponseDTO {

    private Long grupoId;
    private String nombre;
    private List<ResultadoResumenResponseDTO> resultados;

    public GrupoResponseDTO() {
    }

    public GrupoResponseDTO(
            Long grupoId,
            String nombre,
            List<ResultadoResumenResponseDTO> resultados
    ) {
        this.grupoId = grupoId;
        this.nombre = nombre;
        this.resultados = resultados;
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

    public List<ResultadoResumenResponseDTO> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoResumenResponseDTO> resultados) {
        this.resultados = resultados;
    }
}