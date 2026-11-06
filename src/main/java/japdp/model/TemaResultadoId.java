package japdp.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TemaResultadoId implements Serializable {
    Long temaId;
    ResultadoId resultadoId;

    public TemaResultadoId() {
    }

    public TemaResultadoId(Long temaId, ResultadoId resultadoId) {
        this.temaId = temaId;
        this.resultadoId = resultadoId;
    }

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    public ResultadoId getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(ResultadoId resultadoId) {
        this.resultadoId = resultadoId;
    }
}
