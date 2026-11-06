package japdp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tema_Resultado")
public class TemaResultado {
    @EmbeddedId
    TemaResultadoId temaResultadoId;

    @ManyToOne
    @MapsId("temaId")
    @JoinColumn(name = "tema_id")
    private Tema tema;

    @ManyToOne
    @MapsId("resultadoId")
    /*@JoinColumns({
            @JoinColumn(name = "asignatura_id", referencedColumnName = "asignatura_id"),
            @JoinColumn(name = "docente_id", referencedColumnName = "docente_id"),
            @JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")
    })*/
    private Resultado resultado;

    private boolean desarrollada;
    private boolean evaluada;
    private String observaciones;

    public TemaResultado() {
    }

    public TemaResultado(TemaResultadoId temaResultadoId, Tema tema, Resultado resultado, boolean desarrollada, boolean evaluada, String observaciones) {
        this.temaResultadoId = temaResultadoId;
        this.tema = tema;
        this.resultado = resultado;
        this.desarrollada = desarrollada;
        this.evaluada = evaluada;
        this.observaciones = observaciones;
    }

    public TemaResultado(Tema tema, Resultado resultado, boolean desarrollada, boolean evaluada, String observaciones) {
        this.temaResultadoId = new TemaResultadoId(
                tema.getTemaId(), resultado.getResultadoId()
        );
        this.tema = tema;
        this.resultado = resultado;
        this.desarrollada = desarrollada;
        this.evaluada = evaluada;
        this.observaciones = observaciones;
    }

    public TemaResultadoId getTemaResultadoId() {
        return temaResultadoId;
    }

    public void setTemaResultadoId(TemaResultadoId temaResultadoId) {
        this.temaResultadoId = temaResultadoId;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Resultado getResultadoFormulario() {
        return resultado;
    }

    public void setResultadoFormulario(Resultado resultado) {
        this.resultado = resultado;
    }

    public boolean isDesarrollada() {
        return desarrollada;
    }

    public void setDesarrollada(boolean desarrollada) {
        this.desarrollada = desarrollada;
    }

    public boolean isEvaluada() {
        return evaluada;
    }

    public void setEvaluada(boolean evaluada) {
        this.evaluada = evaluada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
