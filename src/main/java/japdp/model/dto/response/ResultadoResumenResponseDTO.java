package japdp.model.dto.response;

/**
 * DTO de respuesta que representa un resultado académico de forma resumida.
 * Incluye únicamente el identificador compuesto del resultado.
 */
public class ResultadoResumenResponseDTO {

    /**
     * Identificador compuesto del resultado.
     */
    private ResultadoIdResponseDTO resultadoId;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public ResultadoResumenResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param resultadoId Identificador compuesto del resultado
     */
    public ResultadoResumenResponseDTO(
            ResultadoIdResponseDTO resultadoId
    ) {
        this.resultadoId = resultadoId;
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