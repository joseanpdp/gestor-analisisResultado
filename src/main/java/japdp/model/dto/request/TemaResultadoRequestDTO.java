package japdp.model.dto.request;

/**
 * DTO de petición que representa la relación entre un tema y un resultado.
 * Contiene el estado de desarrollo, evaluación y observaciones del tema.
 */
public class TemaResultadoRequestDTO {

    /**
     * Identificador del tema asociado.
     */
    Long temaId;

    /**
     * Indica si el tema ha sido desarrollado.
     */
    boolean desarrollada;

    /**
     * Indica si el tema ha sido evaluado.
     */
    boolean evaluada;

    /**
     * Observaciones adicionales sobre el tema.
     */
    String observaciones;

    /**
     * Constructor vacío requerido para la deserialización.
     */
    public TemaResultadoRequestDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param temaId Identificador del tema
     * @param desarrollada Indica si fue desarrollado
     * @param evaluada Indica si fue evaluado
     * @param observaciones Observaciones adicionales
     */
    public TemaResultadoRequestDTO(Long temaId, boolean desarrollada, boolean evaluada, String observaciones) {
        this.temaId = temaId;
        this.desarrollada = desarrollada;
        this.evaluada = evaluada;
        this.observaciones = observaciones;
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