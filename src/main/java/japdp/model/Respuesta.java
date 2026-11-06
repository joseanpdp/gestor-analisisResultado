package japdp.model;

import jakarta.persistence.*;

/**
 * Entidad que representa la respuesta de un formulario.
 * Se corresponde con una tabla en la base de datos.
 */
@Entity
@Table(name = "respuesta")
public class Respuesta {

    /**
     * Identificador único de la respuesta (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long respuestaId;

    /**
     * Resultado asociado a la respuesta.
     * Relación uno a uno: cada respuesta pertenece a un resultado.
     *
     * mappedBy indica que la entidad Resultado es la propietaria de la relación.
     */
    @OneToOne(mappedBy = "respuesta")
    Resultado resultado;

    /**
     * Número total de alumnos del grupo.
     */
    int numeroAlumnosGrupo;

    /**
     * Número de alumnos aprobados.
     */
    int numeroAlumnosAprobados;

    /**
     * Indica si existe dificultad por escasos hábitos de estudio.
     */
    boolean difEscasoHabito;

    /**
     * Indica si existe dificultad por falta de motivación.
     */
    boolean difFaltaMotivacion;

    /**
     * Indica si existe dificultad por bajo nivel académico.
     */
    boolean difBajoNivel;

    /**
     * Indica si existe dificultad por poca colaboración.
     */
    boolean difPocaColaboracion;

    /**
     * Indica si existe dificultad por influencia del clima de aula.
     */
    boolean difInfluenciaClima;

    /**
     * Indica si existe dificultad por carencia de medios.
     */
    boolean difCarenciaMedios;

    /**
     * Indica si existe dificultad por un mal ambiente de trabajo.
     */
    boolean difMalAmbiente;

    /**
     * Descripción de otra dificultad no contemplada.
     */
    String difOtra;

    /**
     * Propuestas de mejora aportadas por el docente.
     */
    String propuestasMejora;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Respuesta() {
    }

    /**
     * Constructor completo de la respuesta.
     *
     * @param respuestaId Identificador único
     * @param resultado Resultado asociado
     * @param numeroAlumnosGrupo Número de alumnos del grupo
     * @param numeroAlumnosAprobados Número de alumnos aprobados
     * @param difEscasoHabito Dificultad por escasos hábitos
     * @param difFaltaMotivacion Dificultad por falta de motivación
     * @param difBajoNivel Dificultad por bajo nivel
     * @param difPocaColaboracion Dificultad por poca colaboración
     * @param difInfluenciaClima Dificultad por clima de aula
     * @param difCarenciaMedios Dificultad por carencia de medios
     * @param difMalAmbiente Dificultad por mal ambiente
     * @param difOtra Otra dificultad descrita
     * @param propuestasMejora Propuestas de mejora
     */
    public Respuesta(Long respuestaId, Resultado resultado, int numeroAlumnosGrupo, int numeroAlumnosAprobados, boolean difEscasoHabito, boolean difFaltaMotivacion, boolean difBajoNivel, boolean difPocaColaboracion, boolean difInfluenciaClima, boolean difCarenciaMedios, boolean difMalAmbiente, String difOtra, String propuestasMejora) {
        this.respuestaId = respuestaId;
        this.resultado = resultado;
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
        this.difEscasoHabito = difEscasoHabito;
        this.difFaltaMotivacion = difFaltaMotivacion;
        this.difBajoNivel = difBajoNivel;
        this.difPocaColaboracion = difPocaColaboracion;
        this.difInfluenciaClima = difInfluenciaClima;
        this.difCarenciaMedios = difCarenciaMedios;
        this.difMalAmbiente = difMalAmbiente;
        this.difOtra = difOtra;
        this.propuestasMejora = propuestasMejora;
    }

    /**
     * Constructor sin resultado ni identificador.
     *
     * @param numeroAlumnosGrupo Número de alumnos del grupo
     * @param numeroAlumnosAprobados Número de alumnos aprobados
     * @param difEscasoHabito Dificultad por escasos hábitos
     * @param difFaltaMotivacion Dificultad por falta de motivación
     * @param difBajoNivel Dificultad por bajo nivel
     * @param difPocaColaboracion Dificultad por poca colaboración
     * @param difInfluenciaClima Dificultad por clima de aula
     * @param difCarenciaMedios Dificultad por carencia de medios
     * @param difMalAmbiente Dificultad por mal ambiente
     * @param difOtra Otra dificultad descrita
     * @param propuestasMejora Propuestas de mejora
     */
    public Respuesta(int numeroAlumnosGrupo, int numeroAlumnosAprobados, boolean difEscasoHabito, boolean difFaltaMotivacion, boolean difBajoNivel, boolean difPocaColaboracion, boolean difInfluenciaClima, boolean difCarenciaMedios, boolean difMalAmbiente, String difOtra, String propuestasMejora) {
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
        this.difEscasoHabito = difEscasoHabito;
        this.difFaltaMotivacion = difFaltaMotivacion;
        this.difBajoNivel = difBajoNivel;
        this.difPocaColaboracion = difPocaColaboracion;
        this.difInfluenciaClima = difInfluenciaClima;
        this.difCarenciaMedios = difCarenciaMedios;
        this.difMalAmbiente = difMalAmbiente;
        this.difOtra = difOtra;
        this.propuestasMejora = propuestasMejora;
    }

    /**
     * Constructor con resultado asociado.
     *
     * @param resultado Resultado asociado
     * @param numeroAlumnosGrupo Número de alumnos del grupo
     * @param numeroAlumnosAprobados Número de alumnos aprobados
     * @param difEscasoHabito Dificultad por escasos hábitos
     * @param difFaltaMotivacion Dificultad por falta de motivación
     * @param difBajoNivel Dificultad por bajo nivel
     * @param difPocaColaboracion Dificultad por poca colaboración
     * @param difInfluenciaClima Dificultad por clima de aula
     * @param difCarenciaMedios Dificultad por carencia de medios
     * @param difMalAmbiente Dificultad por mal ambiente
     * @param difOtra Otra dificultad descrita
     * @param propuestasMejora Propuestas de mejora
     */
    public Respuesta(Resultado resultado, int numeroAlumnosGrupo, int numeroAlumnosAprobados, boolean difEscasoHabito, boolean difFaltaMotivacion, boolean difBajoNivel, boolean difPocaColaboracion, boolean difInfluenciaClima, boolean difCarenciaMedios, boolean difMalAmbiente, String difOtra, String propuestasMejora) {
        this.resultado = resultado;
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
        this.difEscasoHabito = difEscasoHabito;
        this.difFaltaMotivacion = difFaltaMotivacion;
        this.difBajoNivel = difBajoNivel;
        this.difPocaColaboracion = difPocaColaboracion;
        this.difInfluenciaClima = difInfluenciaClima;
        this.difCarenciaMedios = difCarenciaMedios;
        this.difMalAmbiente = difMalAmbiente;
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
     * @return Resultado asociado a la respuesta
     */
    public Resultado getResultado() {
        return resultado;
    }

    /**
     * @param resultado Nuevo resultado asociado
     */
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
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
    public boolean isDifMalAmbiente() {
        return difMalAmbiente;
    }

    /**
     * @param difMalAmbiente Nuevo valor de la dificultad
     */
    public void setDifMalAmbiente(boolean difMalAmbiente) {
        this.difMalAmbiente = difMalAmbiente;
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