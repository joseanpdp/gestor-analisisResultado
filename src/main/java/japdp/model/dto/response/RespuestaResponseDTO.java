package japdp.model.dto.response;

/**
 * DTO de respuesta que representa una respuesta de formulario.
 * Incluye información sobre alumnos, dificultades y propuestas de mejora.
 */
public class RespuestaResponseDTO {

    /**
     * Identificador único de la respuesta.
     */
    private Long respuestaId;

    /**
     * Identificador compuesto del resultado asociado.
     */
    private ResultadoIdResponseDTO resultadoId;

    /**
     * Número total de alumnos del grupo.
     */
    private int numeroAlumnosGrupo;

    /**
     * Número de alumnos aprobados.
     */
    private int numeroAlumnosAprobados;

    /**
     * Indica si existe dificultad por escasos hábitos de estudio.
     */
    private boolean difEscasoHabito;

    /**
     * Indica si existe dificultad por falta de motivación.
     */
    private boolean difFaltaMotivacion;

    /**
     * Indica si existe dificultad por bajo nivel académico.
     */
    private boolean difBajoNivel;

    /**
     * Indica si existe dificultad por poca colaboración.
     */
    private boolean difPocaColaboracion;

    /**
     * Indica si existe dificultad por influencia del clima de aula.
     */
    private boolean difInfluenciaClima;

    /**
     * Indica si existe dificultad por carencia de medios.
     */
    private boolean difCarenciaMedios;

    /**
     * Indica si existe dificultad por un mal ambiente de trabajo.
     */
    private boolean difMalAmiente;

    /**
     * Descripción de otra dificultad no contemplada.
     */
    private String difOtra;

    /**
     * Propuestas de mejora aportadas por el docente.
     */
    private String propuestasMejora;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public RespuestaResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param respuestaId Identificador de la respuesta
     * @param resultadoId Identificador del resultado asociado
     * @param numeroAlumnosGrupo Número de alumnos del grupo
     * @param numeroAlumnosAprobados Número de alumnos aprobados
     * @param difEscasoHabito Dificultad por escasos hábitos
     * @param difFaltaMotivacion Dificultad por falta de motivación
     * @param difBajoNivel Dificultad por bajo nivel
     * @param difPocaColaboracion Dificultad por poca colaboración
     * @param difInfluenciaClima Dificultad por clima de aula
     * @param difCarenciaMedios Dificultad por carencia de medios
     * @param difMalAmiente Dificultad por mal ambiente
     * @param difOtra Otra dificultad descrita
     * @param propuestasMejora Propuestas de mejora
     */
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

    /**
     * @return Identificador de la respuesta
     */
    public Long getRespuestaId() {
        return respuestaId;
    }

    /**
     * @param respuestaId Nuevo identificador de la respuesta
     */
    public void setRespuestaId(Long respuestaId) {
        this.respuestaId = respuestaId;
    }

    /**
     * @return Identificador del resultado asociado
     */
    public ResultadoIdResponseDTO getResultadoId() {
        return resultadoId;
    }

    /**
     * @param resultadoId Nuevo identificador del resultado asociado
     */
    public void setResultadoId(ResultadoIdResponseDTO resultadoId) {
        this.resultadoId = resultadoId;
    }

    /**
     * @return Número de alumnos del grupo
     */
    public int getNumeroAlumnosGrupo() {
        return numeroAlumnosGrupo;
    }

    /**
     * @param numeroAlumnosGrupo Nuevo número de alumnos del grupo
     */
    public void setNumeroAlumnosGrupo(int numeroAlumnosGrupo) {
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
    }

    /**
     * @return Número de alumnos aprobados
     */
    public int getNumeroAlumnosAprobados() {
        return numeroAlumnosAprobados;
    }

    /**
     * @param numeroAlumnosAprobados Nuevo número de alumnos aprobados
     */
    public void setNumeroAlumnosAprobados(int numeroAlumnosAprobados) {
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
    }

    /**
     * @return true si existe dificultad por escasos hábitos
     */
    public boolean isDifEscasoHabito() {
        return difEscasoHabito;
    }

    /**
     * @param difEscasoHabito Nuevo valor de la dificultad
     */
    public void setDifEscasoHabito(boolean difEscasoHabito) {
        this.difEscasoHabito = difEscasoHabito;
    }

    /**
     * @return true si existe dificultad por falta de motivación
     */
    public boolean isDifFaltaMotivacion() {
        return difFaltaMotivacion;
    }

    /**
     * @param difFaltaMotivacion Nuevo valor de la dificultad
     */
    public void setDifFaltaMotivacion(boolean difFaltaMotivacion) {
        this.difFaltaMotivacion = difFaltaMotivacion;
    }

    /**
     * @return true si existe dificultad por bajo nivel académico
     */
    public boolean isDifBajoNivel() {
        return difBajoNivel;
    }

    /**
     * @param difBajoNivel Nuevo valor de la dificultad
     */
    public void setDifBajoNivel(boolean difBajoNivel) {
        this.difBajoNivel = difBajoNivel;
    }

    /**
     * @return true si existe dificultad por poca colaboración
     */
    public boolean isDifPocaColaboracion() {
        return difPocaColaboracion;
    }

    /**
     * @param difPocaColaboracion Nuevo valor de la dificultad
     */
    public void setDifPocaColaboracion(boolean difPocaColaboracion) {
        this.difPocaColaboracion = difPocaColaboracion;
    }

    /**
     * @return true si existe dificultad por influencia del clima de aula
     */
    public boolean isDifInfluenciaClima() {
        return difInfluenciaClima;
    }

    /**
     * @param difInfluenciaClima Nuevo valor de la dificultad
     */
    public void setDifInfluenciaClima(boolean difInfluenciaClima) {
        this.difInfluenciaClima = difInfluenciaClima;
    }

    /**
     * @return true si existe dificultad por carencia de medios
     */
    public boolean isDifCarenciaMedios() {
        return difCarenciaMedios;
    }

    /**
     * @param difCarenciaMedios Nuevo valor de la dificultad
     */
    public void setDifCarenciaMedios(boolean difCarenciaMedios) {
        this.difCarenciaMedios = difCarenciaMedios;
    }

    /**
     * @return true si existe dificultad por un mal ambiente de trabajo
     */
    public boolean isDifMalAmiente() {
        return difMalAmiente;
    }

    /**
     * @param difMalAmiente Nuevo valor de la dificultad
     */
    public void setDifMalAmiente(boolean difMalAmiente) {
        this.difMalAmiente = difMalAmiente;
    }

    /**
     * @return Descripción de otra dificultad
     */
    public String getDifOtra() {
        return difOtra;
    }

    /**
     * @param difOtra Nueva descripción de otra dificultad
     */
    public void setDifOtra(String difOtra) {
        this.difOtra = difOtra;
    }

    /**
     * @return Propuestas de mejora
     */
    public String getPropuestasMejora() {
        return propuestasMejora;
    }

    /**
     * @param propuestasMejora Nuevas propuestas de mejora
     */
    public void setPropuestasMejora(String propuestasMejora) {
        this.propuestasMejora = propuestasMejora;
    }
}