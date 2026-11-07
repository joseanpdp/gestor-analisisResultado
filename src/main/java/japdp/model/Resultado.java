package japdp.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad que representa un resultado académico.
 * Se corresponde con una tabla en la base de datos.
 */
@Entity
@Table(name = "analisis-resultado")
public class Resultado {

    /**
     * Identificador compuesto del resultado.
     * Está formado por asignatura, docente y grupo.
     */
    @EmbeddedId
    ResultadoId resultadoId;

    /**
     * Asignatura asociada al resultado.
     * Relación muchos a uno: varios resultados pueden pertenecer a una asignatura.
     *
     * MapsId indica que el identificador se comparte con la clave compuesta.
     */
    @ManyToOne
    @MapsId("asignaturaId")
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    /**
     * Docente asociado al resultado.
     * Relación muchos a uno: varios resultados pueden pertenecer a un docente.
     *
     * MapsId indica que el identificador se comparte con la clave compuesta.
     */
    @ManyToOne
    @MapsId("docenteId")
    @JoinColumn(name = "docente_id")
    private Docente docente;

    /**
     * Grupo asociado al resultado.
     * Relación muchos a uno: varios resultados pueden pertenecer a un grupo.
     *
     * MapsId indica que el identificador se comparte con la clave compuesta.
     */
    @ManyToOne
    @MapsId("grupoId")
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    /**
     * Respuesta asociada al resultado.
     * Relación uno a uno: cada resultado tiene una respuesta.
     *
     * cascade = ALL propaga todas las operaciones a la respuesta relacionada.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "respuesta_id")
    Respuesta respuesta;

    /**
     * Lista de temas evaluados dentro del resultado.
     * Relación uno a muchos: un resultado puede tener muchos temas evaluados.
     *
     * mappedBy indica que la entidad TemaResultado es la propietaria de la relación.
     * fetch = LAZY indica que los temas se cargan bajo demanda.
     */
    @OneToMany(mappedBy = "resultado", fetch = FetchType.LAZY)
    List<TemaResultado> temasResultados;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Resultado() {
    }

    /**
     * Constructor completo del resultado.
     *
     * @param resultadoId Identificador compuesto
     * @param asignatura Asignatura asociada
     * @param docente Docente asociado
     * @param grupo Grupo asociado
     * @param respuesta Respuesta asociada
     * @param temasResultados Lista de temas evaluados
     */
    public Resultado(ResultadoId resultadoId, Asignatura asignatura, Docente docente, Grupo grupo, Respuesta respuesta, List<TemaResultado> temasResultados) {
        this.resultadoId = resultadoId;
        this.asignatura = asignatura;
        this.docente = docente;
        this.grupo = grupo;
        this.respuesta = respuesta;
        this.temasResultados = temasResultados;
    }

    /**
     * Constructor que crea el identificador compuesto
     * a partir de las entidades relacionadas.
     *
     * @param asignatura Asignatura asociada
     * @param docente Docente asociado
     * @param grupo Grupo asociado
     */
    public Resultado(Asignatura asignatura, Docente docente, Grupo grupo) {
        this.resultadoId = new ResultadoId(
                asignatura.getAsignaturaId(),
                docente.getDocenteId(),
                grupo.getGrupoId()
        );
        this.asignatura = asignatura;
        this.docente = docente;
        this.grupo = grupo;
    }

    /**
     * @return Identificador compuesto del resultado
     */
    public ResultadoId getResultadoId() {
        return resultadoId;
    }

    /**
     * @param resultadoId Nuevo identificador compuesto
     */
    public void setResultadoId(ResultadoId resultadoId) {
        this.resultadoId = resultadoId;
    }

    /**
     * @return Asignatura asociada al resultado
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     * @param asignatura Nueva asignatura asociada
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /**
     * @return Docente asociado al resultado
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * @param docente Nuevo docente asociado
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * @return Grupo asociado al resultado
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * @param grupo Nuevo grupo asociado
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * @return Respuesta asociada al resultado
     */
    public Respuesta getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta Nueva respuesta asociada
     */
    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * @return Lista de temas evaluados
     */
    public List<TemaResultado> getTemasResultados() {
        return temasResultados;
    }

    /**
     * @param temasResultados Nueva lista de temas evaluados
     */
    public void setTemasResultados(List<TemaResultado> temasResultados) {
        this.temasResultados = temasResultados;
    }
}