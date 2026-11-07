package japdp.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un tema dentro de una asignatura.
 * Se corresponde con una tabla en la base de datos.
 */
@Entity
@Table(name = "analisis-tema")
public class Tema {

    /**
     * Identificador único del tema (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long temaId;

    /**
     * Nombre del tema.
     */
    private String nombre;

    /**
     * Asignatura a la que pertenece el tema.
     * Relación muchos a uno: varios temas pueden pertenecer a una asignatura.
     */
    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Tema() {
    }

    /**
     * Constructor básico del tema.
     *
     * @param temaId Identificador único
     * @param nombre Nombre del tema
     */
    public Tema(Long temaId, String nombre) {
        this.temaId = temaId;
        this.nombre = nombre;
    }

    /**
     * Constructor completo del tema.
     *
     * @param temaId Identificador único
     * @param nombre Nombre del tema
     * @param asignatura Asignatura asociada
     */
    public Tema(Long temaId, String nombre, Asignatura asignatura) {
        this.temaId = temaId;
        this.nombre = nombre;
        this.asignatura = asignatura;
    }

    /**
     * @return Identificador del tema
     */
    public Long getTemaId() {
        return temaId;
    }

    /**
     * @param temaId Nuevo identificador del tema
     */
    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    /**
     * @return Nombre del tema
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre del tema
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Asignatura asociada al tema
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
}