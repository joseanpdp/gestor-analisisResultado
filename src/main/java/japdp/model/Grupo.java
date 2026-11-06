package japdp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grupoId;

    private String nombre;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
    private List<Resultado> resultados;

    public Grupo() {
    }

    public Grupo(Long grupoId, String nombre, List<Resultado> resultados) {
        this.grupoId = grupoId;
        this.nombre = nombre;
        this.resultados = resultados;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}