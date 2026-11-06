package japdp.model.dto.response;

public class RespuestaResponseDTO {

    private Long respuestaId;
    private ResultadoIdResponseDTO resultadoId;

    private int numeroAlumnosGrupo;
    private int numeroAlumnosAprobados;

    private boolean difEscasoHabito;
    private boolean difFaltaMotivacion;
    private boolean difBajoNivel;
    private boolean difPocaColaboracion;
    private boolean difInfluenciaClima;
    private boolean difCarenciaMedios;
    private boolean difMalAmiente;

    private String difOtra;
    private String propuestasMejora;

    public RespuestaResponseDTO() {
    }

    public RespuestaResponseDTO(
            Long respuestaId,
            ResultadoIdResponseDTO resultadoId,
            int numeroAlumnosGrupo,
            int numeroAlumnosAprobados,
            boolean difEscasoHabito,
            boolean difFaltaMotivacion,
            boolean difBajoNivel,
            boolean difPocaColaboracion,
            boolean difInfluenciaClima,
            boolean difCarenciaMedios,
            boolean difMalAmiente,
            String difOtra,
            String propuestasMejora
    ) {
        this.respuestaId = respuestaId;
        this.resultadoId = resultadoId;
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
        this.difEscasoHabito = difEscasoHabito;
        this.difFaltaMotivacion = difFaltaMotivacion;
        this.difBajoNivel = difBajoNivel;
        this.difPocaColaboracion = difPocaColaboracion;
        this.difInfluenciaClima = difInfluenciaClima;
        this.difCarenciaMedios = difCarenciaMedios;
        this.difMalAmiente = difMalAmiente;
        this.difOtra = difOtra;
        this.propuestasMejora = propuestasMejora;
    }

    public Long getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(Long respuestaId) {
        this.respuestaId = respuestaId;
    }

    public ResultadoIdResponseDTO getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(ResultadoIdResponseDTO resultadoId) {
        this.resultadoId = resultadoId;
    }

    public int getNumeroAlumnosGrupo() {
        return numeroAlumnosGrupo;
    }

    public void setNumeroAlumnosGrupo(int numeroAlumnosGrupo) {
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
    }

    public int getNumeroAlumnosAprobados() {
        return numeroAlumnosAprobados;
    }

    public void setNumeroAlumnosAprobados(int numeroAlumnosAprobados) {
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
    }

    public boolean isDifEscasoHabito() {
        return difEscasoHabito;
    }

    public void setDifEscasoHabito(boolean difEscasoHabito) {
        this.difEscasoHabito = difEscasoHabito;
    }

    public boolean isDifFaltaMotivacion() {
        return difFaltaMotivacion;
    }

    public void setDifFaltaMotivacion(boolean difFaltaMotivacion) {
        this.difFaltaMotivacion = difFaltaMotivacion;
    }

    public boolean isDifBajoNivel() {
        return difBajoNivel;
    }

    public void setDifBajoNivel(boolean difBajoNivel) {
        this.difBajoNivel = difBajoNivel;
    }

    public boolean isDifPocaColaboracion() {
        return difPocaColaboracion;
    }

    public void setDifPocaColaboracion(boolean difPocaColaboracion) {
        this.difPocaColaboracion = difPocaColaboracion;
    }

    public boolean isDifInfluenciaClima() {
        return difInfluenciaClima;
    }

    public void setDifInfluenciaClima(boolean difInfluenciaClima) {
        this.difInfluenciaClima = difInfluenciaClima;
    }

    public boolean isDifCarenciaMedios() {
        return difCarenciaMedios;
    }

    public void setDifCarenciaMedios(boolean difCarenciaMedios) {
        this.difCarenciaMedios = difCarenciaMedios;
    }

    public boolean isDifMalAmiente() {
        return difMalAmiente;
    }

    public void setDifMalAmiente(boolean difMalAmiente) {
        this.difMalAmiente = difMalAmiente;
    }

    public String getDifOtra() {
        return difOtra;
    }

    public void setDifOtra(String difOtra) {
        this.difOtra = difOtra;
    }

    public String getPropuestasMejora() {
        return propuestasMejora;
    }

    public void setPropuestasMejora(String propuestasMejora) {
        this.propuestasMejora = propuestasMejora;
    }
}