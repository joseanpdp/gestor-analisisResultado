package japdp.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad que representa una asignatura del sistema.
 * Se corresponde con una tabla en la base de datos.
 */
@Entity
@Table(name = "asignatura")
public class Asignatura {

    /**
     * Identificador único de la asignatura (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asignaturaId;

    /**
     * Nombre de la asignatura.
     */
    private String nombre;

    /**
     * Abreviatura de la asignatura.
     */
    private String abreviatura;

    /**
     * Nivel educativo de la asignatura.
     */
    private String nivel;

    /**
     * Lista de temas asociados a la asignatura.
     * Relación uno a muchos: una asignatura puede tener muchos temas.
     *
     * mappedBy indica que la entidad Tema es la propietaria de la relación.
     */
    @OneToMany(mappedBy = "asignatura")
    private List<Tema> temas;

    /**
     * Lista de resultados asociados a la asignatura.
     * Relación uno a muchos: una asignatura puede tener muchos resultados.
     *
     * mappedBy indica que la entidad Resultado es la propietaria de la relación.
     * fetch = EAGER indica que los resultados se cargan de forma inmediata.
     */
    @OneToMany(mappedBy = "asignatura", fetch = FetchType.EAGER)
    private List<Resultado> resultados;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Asignatura() {
    }

    /**
     * Constructor completo de la asignatura.
     *
     * @param asignaturaId Identificador único
     * @param nombre Nombre de la asignatura
     * @param abreviatura Abreviatura de la asignatura
     * @param nivel Nivel educativo
     * @param temas Lista de temas
     * @param resultados Lista de resultados
     */
    public Asignatura(Long asignaturaId, String nombre, String abreviatura, String nivel, List<Tema> temas, List<Resultado> resultados) {
        this.asignaturaId = asignaturaId;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.nivel = nivel;
        this.temas = temas;
        this.resultados = resultados;
    }

    /**
     * @return Identificador de la asignatura
     */
    public Long getAsignaturaId() {
        return asignaturaId;
    }

    /**
     * @param asignaturaId Nuevo identificador de la asignatura
     */
    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    /**
     * @return Nombre de la asignatura
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre de la asignatura
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Abreviatura de la asignatura
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * @param abreviatura Nueva abreviatura de la asignatura
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * @return Nivel educativo de la asignatura
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel Nuevo nivel educativo
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * @return Lista de temas de la asignatura
     */
    public List<Tema> getTemas() {
        return temas;
    }

    /**
     * @param temas Nueva lista de temas
     */
    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    /**
     * @return Lista de resultados de la asignatura
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
}