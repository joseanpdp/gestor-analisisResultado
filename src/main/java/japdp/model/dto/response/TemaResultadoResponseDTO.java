package japdp.model.dto.response;

public class TemaResultadoResponseDTO {

    private TemaResultadoIdResponseDTO id;
    private TemaResumenResponseDTO tema;

    private boolean desarrollada;
    private boolean evaluada;
    private String observaciones;

    public TemaResultadoResponseDTO() {
    }

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

    public TemaResultadoIdResponseDTO getId() {
        return id;
    }

    public void setId(TemaResultadoIdResponseDTO id) {
        this.id = id;
    }

    public TemaResumenResponseDTO getTema() {
        return tema;
    }

    public void setTema(TemaResumenResponseDTO tema) {
        this.tema = tema;
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