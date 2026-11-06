package japdp.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ResultadoId implements Serializable {
    Long asignaturaId;
    Long docenteId;
    Long grupoId;

    public ResultadoId() {
    }

    public ResultadoId(Long asignaturaId, Long docenteId, Long grupoId) {
        this.asignaturaId = asignaturaId;
        this.docenteId = docenteId;
        this.grupoId = grupoId;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }
}
