package japdp.model.dto.response;

public class TemaResultadoIdResponseDTO {

    private Long temaId;
    private ResultadoIdResponseDTO resultadoId;

    public TemaResultadoIdResponseDTO() {
    }

    public TemaResultadoIdResponseDTO(
            Long temaId,
            ResultadoIdResponseDTO resultadoId
    ) {
        this.temaId = temaId;
        this.resultadoId = resultadoId;
    }

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    public ResultadoIdResponseDTO getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(ResultadoIdResponseDTO resultadoId) {
        this.resultadoId = resultadoId;
    }
}