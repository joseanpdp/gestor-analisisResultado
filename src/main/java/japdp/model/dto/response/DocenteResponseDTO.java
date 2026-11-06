package japdp.model.dto.response;

import japdp.model.Role;
import japdp.model.dto.response.ResultadoResumenResponseDTO;

import java.util.List;

/**
 * DTO de respuesta que representa a un docente.
 * Incluye los datos básicos del docente y sus resultados asociados.
 */
public class DocenteResponseDTO {

    /**
     * Identificador único del docente.
     */
    private Long docenteId;

    /**
     * Nombre del docente.
     */
    private String nombre;

    /**
     * Rol del docente dentro del sistema.
     */
    private Role role;

    /**
     * Lista de resultados asociados al docente.
     */
    private List<ResultadoResumenResponseDTO> resultados;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public DocenteResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param docenteId Identificador del docente
     * @param nombre Nombre del docente
     * @param role Rol del docente
     * @param resultados Lista de resultados asociados
     */
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
     * @return Nombre del docente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre del docente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Rol del docente
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role Nuevo rol del docente
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return Lista de resultados asociados al docente
     */
    public List<ResultadoResumenResponseDTO> getResultados() {
        return resultados;
    }

    /**
     * @param resultados Nueva lista de resultados
     */
    public void setResultados(List<ResultadoResumenResponseDTO> resultados) {
        this.resultados = resultados;
    }
}