package japdp.model.dto.response;

import japdp.model.Role;
import japdp.model.dto.response.ResultadoResumenResponseDTO;

import java.util.List;

public class DocenteResponseDTO {

    private Long docenteId;
    private String nombre;
    private Role role;
    private List<ResultadoResumenResponseDTO> resultados;

    public DocenteResponseDTO() {
    }

    public DocenteResponseDTO(
            Long docenteId,
            String nombre,
            Role role,
            List<ResultadoResumenResponseDTO> resultados
    ) {
        this.docenteId = docenteId;
        this.nombre = nombre;
        this.role = role;
        this.resultados = resultados;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<ResultadoResumenResponseDTO> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoResumenResponseDTO> resultados) {
        this.resultados = resultados;
    }
}