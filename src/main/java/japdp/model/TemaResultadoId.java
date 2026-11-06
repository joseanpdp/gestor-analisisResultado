package japdp.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * Clave compuesta de la entidad TemaResultado.
 * Está formada por el identificador del tema y el identificador del resultado.
 */
@Embeddable
public class TemaResultadoId implements Serializable {

    /**
     * Identificador del tema.
     */
    Long temaId;

    /**
     * Identificador compuesto del resultado.
     */
    ResultadoId resultadoId;

    /**
     * Constructor vacío requerido por JPA.
     */
    public TemaResultadoId() {
    }

    /**
     * Constructor completo de la clave compuesta.
     *
     * @param temaId Identificador del tema
     * @param resultadoId Identificador compuesto del resultado
     */
    public TemaResultadoId(Long temaId, ResultadoId resultadoId) {
        this.temaId = temaId;
        this.resultadoId = resultadoId;
    }

    /**
     * @return Identificador del tema
     */
    public Long getTemaId() {
        return temaId;
    }

    /**
     * @param temaId Nuevo identificador del tema
     */
    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    /**
     * @return Identificador compuesto del resultado
     */
    public ResultadoId getResultadoId() {
        return resultadoId;
    }

    /**
     * @param resultadoId Nuevo identificador compuesto del resultado
     */
    public void setResultadoId(ResultadoId resultadoId) {
        this.resultadoId = resultadoId;
    }
}