package japdp.model.dto.request;

public class TemaResultadoRequestDTO {
    Long temaId;
    boolean desarrollada;
    boolean evaluada;
    String observaciones;

    public TemaResultadoRequestDTO() {
    }

    public TemaResultadoRequestDTO(Long temaId, boolean desarrollada, boolean evaluada, String observaciones) {
        this.temaId = temaId;
        this.desarrollada = desarrollada;
        this.evaluada = evaluada;
        this.observaciones = observaciones;
    }

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
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
