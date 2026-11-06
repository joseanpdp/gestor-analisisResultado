package japdp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asignaturaId;

    private String nombre;
    private String abreviatura;
    private String nivel;

    @OneToMany(mappedBy = "asignatura")
    private List<Tema> temas;

    @OneToMany(mappedBy = "asignatura", fetch = FetchType.EAGER)
    private List<Resultado> resultados;

    public Asignatura() {
    }

    public Asignatura(Long asignaturaId, String nombre, String abreviatura, String nivel, List<Tema> temas, List<Resultado> resultados) {
        this.asignaturaId = asignaturaId;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.nivel = nivel;
        this.temas = temas;
        this.resultados = resultados;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}