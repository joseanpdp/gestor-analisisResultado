package japdp.model.dto.response;

import japdp.model.dto.response.ResultadoResumenResponseDTO;

import java.util.List;

/**
 * DTO de respuesta que representa un grupo.
 * Incluye los resultados asociados al grupo.
 */
public class GrupoResponseDTO {

    /**
     * Identificador único del grupo.
     */
    private Long grupoId;

    /**
     * Nombre del grupo.
     */
    private String nombre;

    /**
     * Lista de resultados asociados al grupo.
     */
    private List<ResultadoResumenResponseDTO> resultados;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public GrupoResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param grupoId Identificador del grupo
     * @param nombre Nombre del grupo
     * @param resultados Lista de resultados asociados
     */
    public GrupoResponseDTO(
            Long grupoId,
            String nombre,
            List<ResultadoResumenResponseDTO> resultados
    ) {
        this.grupoId = grupoId;
        this.nombre = nombre;
        this.resultados = resultados;
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

    /**
     * @return Nombre del grupo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre del grupo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Lista de resultados asociados al grupo
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