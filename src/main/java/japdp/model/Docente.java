package japdp.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad que representa a un docente del sistema.
 * Se corresponde con una tabla en la base de datos.
 */
@Entity
@Table(name = "analisis-docente")
public class Docente {

    /**
     * Identificador único del docente (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docenteId;

    /**
     * Nombre del docente.
     */
    private String nombre;

    /**
     * Lista de resultados asociados al docente.
     * Relación uno a muchos: un docente puede tener muchos resultados.
     *
     * mappedBy indica que la entidad Resultado es la propietaria de la relación.
     * fetch = EAGER indica que los resultados se cargan de forma inmediata.
     */
    @OneToMany(mappedBy = "docente", fetch = FetchType.EAGER)
    private List<Resultado> resultados;

    /**
     * Usuario asociado al docente.
     * Relación uno a uno: cada docente tiene un usuario asociado.
     *
     * cascade = ALL propaga todas las operaciones al usuario relacionado.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Docente() {
    }

    /**
     * Constructor completo del docente.
     *
     * @param docenteId Identificador único
     * @param nombre Nombre del docente
     * @param resultados Lista de resultados
     * @param usuario Usuario asociado
     */
    public Docente(Long docenteId, String nombre, List<Resultado> resultados, Usuario usuario) {
        this.docenteId = docenteId;
        this.nombre = nombre;
        this.resultados = resultados;
        this.usuario = usuario;
    }

    /**
     * @return Identificador del docente
     */
    public Long getDocenteId() {
        return docenteId;
    }

    /**
     * @param docenteId Nuevo identificador del docente
     */
    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    /**
     * @return Nombre del docente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre del docente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Lista de resultados del docente
     */
    public List<Resultado> getResultados() {
        return resultados;
    }

    /**
     * @param resultados Nueva lista de resultados
     */
    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    /**
     * @return Usuario asociado al docente
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario Nuevo usuario asociado al docente
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}