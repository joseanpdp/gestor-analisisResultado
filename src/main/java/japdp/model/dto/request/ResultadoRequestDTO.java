package japdp.model.dto.request;

import java.util.List;

/**
 * DTO de petición que representa un resultado académico.
 * Contiene los identificadores necesarios y la información del formulario.
 */
public class ResultadoRequestDTO {

    /**
     * Identificador de la asignatura asociada.
     */
    Long asignaturaId;

    /**
     * Identificador del docente asociado.
     */
    Long docenteId;

    /**
     * Identificador del grupo asociado.
     */
    Long grupoId;

    /**
     * Lista de temas evaluados dentro del resultado.
     */
    List<TemaResultadoRequestDTO> temasResultados;

    /**
     * Respuesta asociada al resultado.
     */
    RespuestaRequestDTO respuesta;

    /**
     * Constructor vacío requerido para la deserialización.
     */
    public ResultadoRequestDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param asignaturaId Identificador de la asignatura
     * @param docenteId Identificador del docente
     * @param grupoId Identificador del grupo
     * @param temasResultados Lista de temas evaluados
     * @param respuesta Respuesta asociada
     */
    public ResultadoRequestDTO(Long asignaturaId, Long docenteId, Long grupoId, List<TemaResultadoRequestDTO> temasResultados, RespuestaRequestDTO respuesta) {
        this.asignaturaId = asignaturaId;
        this.docenteId = docenteId;
        this.grupoId = grupoId;
        this.temasResultados = temasResultados;
        this.respuesta = respuesta;
    }

    /**
     * @return Identificador de la asignatura
     */
    public Long getAsignaturaId() {
        return asignaturaId;
    }

    /**
     * @param asignaturaId Nuevo identificador de la asignatura
     */
    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
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
     * @return Lista de temas evaluados
     */
    public List<TemaResultadoRequestDTO> getTemasResultados() {
        return temasResultados;
    }

    /**
     * @param temasResultados Nueva lista de temas evaluados
     */
    public void setTemasResultados(List<TemaResultadoRequestDTO> temasResultados) {
        this.temasResultados = temasResultados;
    }

    /**
     * @return Respuesta asociada al resultado
     */
    public RespuestaRequestDTO getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta Nueva respuesta asociada
     */
    public void setRespuesta(RespuestaRequestDTO respuesta) {
        this.respuesta = respuesta;
    }
}