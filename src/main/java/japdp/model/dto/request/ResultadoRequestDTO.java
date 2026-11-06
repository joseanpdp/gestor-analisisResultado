package japdp.model.dto.request;

import java.util.List;

public class ResultadoRequestDTO {
    Long asignaturaId;
    Long docenteId;
    Long grupoId;
    List<TemaResultadoRequestDTO> temasResultados;
    RespuestaRequestDTO respuesta;

    public ResultadoRequestDTO() {
    }

    public ResultadoRequestDTO(Long asignaturaId, Long docenteId, Long grupoId, List<TemaResultadoRequestDTO> temasResultados, RespuestaRequestDTO respuesta) {
        this.asignaturaId = asignaturaId;
        this.docenteId = docenteId;
        this.grupoId = grupoId;
        this.temasResultados = temasResultados;
        this.respuesta = respuesta;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public List<TemaResultadoRequestDTO> getTemasResultados() {
        return temasResultados;
    }

    public void setTemasResultados(List<TemaResultadoRequestDTO> temasResultados) {
        this.temasResultados = temasResultados;
    }

    public RespuestaRequestDTO getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaRequestDTO respuesta) {
        this.respuesta = respuesta;
    }
}
