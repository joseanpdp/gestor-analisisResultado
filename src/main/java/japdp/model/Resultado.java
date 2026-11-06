package japdp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "resultado")
public class Resultado {
    @EmbeddedId
    ResultadoId resultadoId;

    @ManyToOne
    @MapsId("asignaturaId")
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @ManyToOne
    @MapsId("docenteId")
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @ManyToOne
    @MapsId("grupoId")
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "respuesta_id")
    Respuesta respuesta;

    @OneToMany(mappedBy = "resultado", fetch = FetchType.LAZY)
    List<TemaResultado> temasResultados;

    public Resultado() {
    }

    public Resultado(ResultadoId resultadoId, Asignatura asignatura, Docente docente, Grupo grupo, Respuesta respuesta, List<TemaResultado> temasResultados) {
        this.resultadoId = resultadoId;
        this.asignatura = asignatura;
        this.docente = docente;
        this.grupo = grupo;
        this.respuesta = respuesta;
        this.temasResultados = temasResultados;
    }

    public Resultado(Asignatura asignatura, Docente docente, Grupo grupo) {
        this.resultadoId = new ResultadoId(
                asignatura.getAsignaturaId(),
                docente.getDocenteId(),
                grupo.getGrupoId()
        );
        this.asignatura = asignatura;
        this.docente = docente;
        this.grupo = grupo;
    }

    public ResultadoId getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(ResultadoId resultadoId) {
        this.resultadoId = resultadoId;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public List<TemaResultado> getTemasResultados() {
        return temasResultados;
    }

    public void setTemasResultados(List<TemaResultado> temasResultados) {
        this.temasResultados = temasResultados;
    }
}
