package japdp.model.dto.response;

import java.util.List;

/**
 * DTO de respuesta que representa un resultado académico completo.
 * Incluye la asignatura, el docente, el grupo, la respuesta y los temas evaluados.
 */
public class ResultadoResponseDTO {

    /**
     * Identificador compuesto del resultado.
     */
    private ResultadoIdResponseDTO resultadoId;

    /**
     * Asignatura asociada al resultado.
     */
    private AsignaturaResumenResponseDTO asignatura;

    /**
     * Docente asociado al resultado.
     */
    private DocenteResumenResponseDTO docente;

    /**
     * Grupo asociado al resultado.
     */
    private GrupoResumenResponseDTO grupo;

    /**
     * Respuesta asociada al resultado.
     */
    private RespuestaResponseDTO respuesta;

    /**
     * Lista de temas evaluados dentro del resultado.
     */
    private List<TemaResultadoResponseDTO> temasResultados;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public ResultadoResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param resultadoId Identificador compuesto del resultado
     * @param asignatura Asignatura asociada
     * @param docente Docente asociado
     * @param grupo Grupo asociado
     * @param respuesta Respuesta asociada
     * @param temasResultados Lista de temas evaluados
     */
    public ResultadoResponseDTO(
            ResultadoIdResponseDTO resultadoId,
            AsignaturaResumenResponseDTO asignatura,
            DocenteResumenResponseDTO docente,
            GrupoResumenResponseDTO grupo,
            RespuestaResponseDTO respuesta,
            List<TemaResultadoResponseDTO> temasResultados
    ) {
        this.resultadoId = resultadoId;
        this.asignatura = asignatura;
        this.docente = docente;
        this.grupo = grupo;
        this.respuesta = respuesta;
        this.temasResultados = temasResultados;
    }

    /**
     * @return Identificador compuesto del resultado
     */
    public ResultadoIdResponseDTO getResultadoId() {
        return resultadoId;
    }

    /**
     * @param resultadoId Nuevo identificador compuesto del resultado
     */
    public void setResultadoId(ResultadoIdResponseDTO resultadoId) {
        this.resultadoId = resultadoId;
    }

    /**
     * @return Asignatura asociada al resultado
     */
    public AsignaturaResumenResponseDTO getAsignatura() {
        return asignatura;
    }

    /**
     * @param asignatura Nueva asignatura asociada
     */
    public void setAsignatura(AsignaturaResumenResponseDTO asignatura) {
        this.asignatura = asignatura;
    }

    /**
     * @return Docente asociado al resultado
     */
    public DocenteResumenResponseDTO getDocente() {
        return docente;
    }

    /**
     * @param docente Nuevo docente asociado
     */
    public void setDocente(DocenteResumenResponseDTO docente) {
        this.docente = docente;
    }

    /**
     * @return Grupo asociado al resultado
     */
    public GrupoResumenResponseDTO getGrupo() {
        return grupo;
    }

    /**
     * @param grupo Nuevo grupo asociado
     */
    public void setGrupo(GrupoResumenResponseDTO grupo) {
        this.grupo = grupo;
    }

    /**
     * @return Respuesta asociada al resultado
     */
    public RespuestaResponseDTO getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta Nueva respuesta asociada
     */
    public void setRespuesta(RespuestaResponseDTO respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * @return Lista de temas evaluados
     */
    public List<TemaResultadoResponseDTO> getTemasResultados() {
        return temasResultados;
    }

    /**
     * @param temasResultados Nueva lista de temas evaluados
     */
    public void setTemasResultados(List<TemaResultadoResponseDTO> temasResultados) {
        this.temasResultados = temasResultados;
    }
}