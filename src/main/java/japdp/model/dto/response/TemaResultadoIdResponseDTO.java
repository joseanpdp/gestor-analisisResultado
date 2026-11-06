package japdp.model.dto.response;

/**
 * DTO de respuesta que representa el identificador compuesto
 * de la relación entre un tema y un resultado.
 */
public class TemaResultadoIdResponseDTO {

    /**
     * Identificador del tema.
     */
    private Long temaId;

    /**
     * Identificador compuesto del resultado.
     */
    private ResultadoIdResponseDTO resultadoId;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public TemaResultadoIdResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param temaId Identificador del tema
     * @param resultadoId Identificador compuesto del resultado
     */
    public TemaResultadoIdResponseDTO(
            Long temaId,
            ResultadoIdResponseDTO resultadoId
    ) {
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
    public ResultadoIdResponseDTO getResultadoId() {
        return resultadoId;
    }

    /**
     * @param resultadoId Nuevo identificador compuesto del resultado
     */
    public void setResultadoId(ResultadoIdResponseDTO resultadoId) {
        this.resultadoId = resultadoId;
    }
}