package japdp.model.dto.response;

/**
 * DTO de respuesta que representa la relación entre un tema y un resultado.
 * Incluye el estado de desarrollo, evaluación y observaciones del tema.
 */
public class TemaResultadoResponseDTO {

    /**
     * Identificador compuesto de la relación tema-resultado.
     */
    private TemaResultadoIdResponseDTO id;

    /**
     * Tema asociado a la relación.
     */
    private TemaResumenResponseDTO tema;

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
     * Constructor vacío requerido para la serialización.
     */
    public TemaResultadoResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param id Identificador compuesto de la relación
     * @param tema Tema asociado
     * @param desarrollada Indica si fue desarrollado
     * @param evaluada Indica si fue evaluado
     * @param observaciones Observaciones adicionales
     */
    public TemaResultadoResponseDTO(
            TemaResultadoIdResponseDTO id,
            TemaResumenResponseDTO tema,
            boolean desarrollada,
            boolean evaluada,
            String observaciones
    ) {
        this.id = id;
        this.tema = tema;
        this.desarrollada = desarrollada;
        this.evaluada = evaluada;
        this.observaciones = observaciones;
    }

    /**
     * @return Identificador compuesto de la relación
     */
    public TemaResultadoIdResponseDTO getId() {
        return id;
    }

    /**
     * @param id Nuevo identificador compuesto de la relación
     */
    public void setId(TemaResultadoIdResponseDTO id) {
        this.id = id;
    }

    /**
     * @return Tema asociado a la relación
     */
    public TemaResumenResponseDTO getTema() {
        return tema;
    }

    /**
     * @param tema Nuevo tema asociado
     */
    public void setTema(TemaResumenResponseDTO tema) {
        this.tema = tema;
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