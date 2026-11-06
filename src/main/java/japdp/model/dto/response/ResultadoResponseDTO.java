package japdp.model.dto.response;

import java.util.List;

public class ResultadoResponseDTO {

    private ResultadoIdResponseDTO resultadoId;
    private AsignaturaResumenResponseDTO asignatura;
    private DocenteResumenResponseDTO docente;
    private GrupoResumenResponseDTO grupo;
    private RespuestaResponseDTO respuesta;
    private List<TemaResultadoResponseDTO> temasResultados;

    public ResultadoResponseDTO() {
    }

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

    public ResultadoIdResponseDTO getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(ResultadoIdResponseDTO resultadoId) {
        this.resultadoId = resultadoId;
    }

    public AsignaturaResumenResponseDTO getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturaResumenResponseDTO asignatura) {
        this.asignatura = asignatura;
    }

    public DocenteResumenResponseDTO getDocente() {
        return docente;
    }

    public void setDocente(DocenteResumenResponseDTO docente) {
        this.docente = docente;
    }

    public GrupoResumenResponseDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoResumenResponseDTO grupo) {
        this.grupo = grupo;
    }

    public RespuestaResponseDTO getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaResponseDTO respuesta) {
        this.respuesta = respuesta;
    }

    public List<TemaResultadoResponseDTO> getTemasResultados() {
        return temasResultados;
    }

    public void setTemasResultados(List<TemaResultadoResponseDTO> temasResultados) {
        this.temasResultados = temasResultados;
    }
}