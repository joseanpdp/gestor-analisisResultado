package japdp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long temaId;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    public Tema() {
    }

    public Tema(Long temaId, String nombre) {
        this.temaId = temaId;
        this.nombre = nombre;
    }

    public Tema(Long temaId, String nombre, Asignatura asignatura) {
        this.temaId = temaId;
        this.nombre = nombre;
        this.asignatura = asignatura;
    }

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
