package japdp.model.dto.response;

public class ResultadoResumenResponseDTO {
    private ResultadoIdResponseDTO resultadoId;

    public ResultadoResumenResponseDTO() {
    }

    public ResultadoResumenResponseDTO(
            ResultadoIdResponseDTO resultadoId
    ) {
        this.resultadoId = resultadoId;
    }

    public ResultadoIdResponseDTO getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(ResultadoIdResponseDTO resultadoId) {
        this.resultadoId = resultadoId;
    }
}