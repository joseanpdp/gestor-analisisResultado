package japdp.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * Clave compuesta de la entidad Resultado.
 * Está formada por los identificadores de asignatura, docente y grupo.
 */
@Embeddable
public class ResultadoId implements Serializable {

    /**
     * Identificador de la asignatura.
     */
    Long asignaturaId;

    /**
     * Identificador del docente.
     */
    Long docenteId;

    /**
     * Identificador del grupo.
     */
    Long grupoId;

    /**
     * Constructor vacío requerido por JPA.
     */
    public ResultadoId() {
    }

    /**
     * Constructor completo de la clave compuesta.
     *
     * @param asignaturaId Identificador de la asignatura
     * @param docenteId Identificador del docente
     * @param grupoId Identificador del grupo
     */
    public ResultadoId(Long asignaturaId, Long docenteId, Long grupoId) {
        this.asignaturaId = asignaturaId;
        this.docenteId = docenteId;
        this.grupoId = grupoId;
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
}