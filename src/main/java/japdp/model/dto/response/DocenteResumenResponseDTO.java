package japdp.model.dto.response;

import japdp.model.Role;

public class DocenteResumenResponseDTO {

    private Long docenteId;
    private String nombre;
    private Role role;

    public DocenteResumenResponseDTO() {
    }

    public DocenteResumenResponseDTO(
            Long docenteId,
            String nombre,
            Role role
    ) {
        this.docenteId = docenteId;
        this.nombre = nombre;
        this.role = role;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}