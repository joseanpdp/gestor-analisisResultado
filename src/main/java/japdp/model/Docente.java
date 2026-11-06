package japdp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docenteId;

    private String nombre;

    @OneToMany(mappedBy = "docente", fetch = FetchType.EAGER)
    private List<Resultado> resultados;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    public Docente() {
    }

    public Docente(Long docenteId, String nombre, List<Resultado> resultados, Usuario usuario) {
        this.docenteId = docenteId;
        this.nombre = nombre;
        this.resultados = resultados;
        this.usuario = usuario;
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

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
