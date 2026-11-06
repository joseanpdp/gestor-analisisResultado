package japdp.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad que representa un grupo de alumnos.
 * Se corresponde con una tabla en la base de datos.
 */
@Entity
@Table(name = "grupo")
public class Grupo {

    /**
     * Identificador único del grupo (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grupoId;

    /**
     * Nombre del grupo.
     */
    private String nombre;

    /**
     * Lista de resultados asociados al grupo.
     * Relación uno a muchos: un grupo puede tener muchos resultados.
     *
     * mappedBy indica que la entidad Resultado es la propietaria de la relación.
     * fetch = EAGER indica que los resultados se cargan de forma inmediata.
     */
    @OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
    private List<Resultado> resultados;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Grupo() {
    }

    /**
     * Constructor completo del grupo.
     *
     * @param grupoId Identificador único
     * @param nombre Nombre del grupo
     * @param resultados Lista de resultados
     */
    public Grupo(Long grupoId, String nombre, List<Resultado> resultados) {
        this.grupoId = grupoId;
        this.nombre = nombre;
        this.resultados = resultados;
    }

    /**
     * @return Identificador del grupo
     */
    public Long getGrupoId() {
        return grupoId;
    }

    /**
     * @param grupoId Nuevo identificador del grupo
     */
    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    /**
     * @return Nombre del grupo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre del grupo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Lista de resultados del grupo
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