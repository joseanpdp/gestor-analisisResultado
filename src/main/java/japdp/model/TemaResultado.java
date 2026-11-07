package japdp.model;

import jakarta.persistence.*;

/**
 * Entidad que representa la relación entre un tema y un resultado.
 * Se corresponde con una tabla en la base de datos.
 */
@Entity
@Table(name = "analisis-tema_Resultado")
public class TemaResultado {

    /**
     * Identificador compuesto de la relación.
     * Está formado por el identificador del tema y el del resultado.
     */
    @EmbeddedId
    TemaResultadoId temaResultadoId;

    /**
     * Tema asociado a la relación.
     * Relación muchos a uno: varios registros pueden pertenecer a un tema.
     *
     * MapsId indica que el identificador se comparte con la clave compuesta.
     */
    @ManyToOne
    @MapsId("temaId")
    @JoinColumn(name = "tema_id")
    private Tema tema;

    /**
     * Resultado asociado a la relación.
     * Relación muchos a uno: varios registros pueden pertenecer a un resultado.
     *
     * MapsId indica que el identificador se comparte con la clave compuesta.
     */
    @ManyToOne
    @MapsId("resultadoId")
    private Resultado resultado;

    /**
     * Indica si el tema ha sido desarrollado.
     */
    private boolean desarrollada;

    /**
     * Indica si el tema ha sido evaluado.
     */
    private boolean evaluada;

    /**
     * Observaciones adicionales sobre el tema.
     */
    private String observaciones;

    /**
     * Constructor vacío requerido por JPA.
     */
    public TemaResultado() {
    }

    /**
     * Constructor completo de la relación.
     *
     * @param temaResultadoId Identificador compuesto
     * @param tema Tema asociado
     * @param resultado Resultado asociado
     * @param desarrollada Indica si fue desarrollado
     * @param evaluada Indica si fue evaluado
     * @param observaciones Observaciones adicionales
     */
    public TemaResultado(TemaResultadoId temaResultadoId, Tema tema, Resultado resultado, boolean desarrollada, boolean evaluada, String observaciones) {
        this.temaResultadoId = temaResultadoId;
        this.tema = tema;
        this.resultado = resultado;
        this.desarrollada = desarrollada;
        this.evaluada = evaluada;
        this.observaciones = observaciones;
    }

    /**
     * Constructor que crea el identificador compuesto
     * a partir de las entidades relacionadas.
     *
     * @param tema Tema asociado
     * @param resultado Resultado asociado
     * @param desarrollada Indica si fue desarrollado
     * @param evaluada Indica si fue evaluado
     * @param observaciones Observaciones adicionales
     */
    public TemaResultado(Tema tema, Resultado resultado, boolean desarrollada, boolean evaluada, String observaciones) {
        this.temaResultadoId = new TemaResultadoId(
                tema.getTemaId(),
                resultado.getResultadoId()
        );
        this.tema = tema;
        this.resultado = resultado;
        this.desarrollada = desarrollada;
        this.evaluada = evaluada;
        this.observaciones = observaciones;
    }

    /**
     * @return Identificador compuesto de la relación
     */
    public TemaResultadoId getTemaResultadoId() {
        return temaResultadoId;
    }

    /**
     * @param temaResultadoId Nuevo identificador compuesto
     */
    public void setTemaResultadoId(TemaResultadoId temaResultadoId) {
        this.temaResultadoId = temaResultadoId;
    }

    /**
     * @return Tema asociado a la relación
     */
    public Tema getTema() {
        return tema;
    }

    /**
     * @param tema Nuevo tema asociado
     */
    public void setTema(Tema tema) {
        this.tema = tema;
    }

    /**
     * @return Resultado asociado a la relación
     */
    public Resultado getResultadoFormulario() {
        return resultado;
    }

    /**
     * @param resultado Nuevo resultado asociado
     */
    public void setResultadoFormulario(Resultado resultado) {
        this.resultado = resultado;
    }

    /**
     * @return true si el tema fue desarrollado
     */
    public boolean isDesarrollada() {
        return desarrollada;
    }

    /**
     * @param desarrollada Nuevo valor del estado de desarrollo
     */
    public void setDesarrollada(boolean desarrollada) {
        this.desarrollada = desarrollada;
    }

    /**
     * @return true si el tema fue evaluado
     */
    public boolean isEvaluada() {
        return evaluada;
    }

    /**
     * @param evaluada Nuevo valor del estado de evaluación
     */
    public void setEvaluada(boolean evaluada) {
        this.evaluada = evaluada;
    }

    /**
     * @return Observaciones adicionales del tema
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones Nuevas observaciones del tema
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}