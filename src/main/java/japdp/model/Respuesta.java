package japdp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long respuestaId;

    @OneToOne(mappedBy = "respuesta")
    Resultado resultado;

    int numeroAlumnosGrupo;
    int numeroAlumnosAprobados;
    boolean difEscasoHabito;
    boolean difFaltaMotivacion;
    boolean difBajoNivel;
    boolean difPocaColaboracion;
    boolean difInfluenciaClima;
    boolean difCarenciaMedios;
    boolean difMalAmbiente;
    String difOtra;
    String propuestasMejora;

    public Respuesta() {
    }

    public Respuesta(Long respuestaId, Resultado resultado, int numeroAlumnosGrupo, int numeroAlumnosAprobados, boolean difEscasoHabito, boolean difFaltaMotivacion, boolean difBajoNivel, boolean difPocaColaboracion, boolean difInfluenciaClima, boolean difCarenciaMedios, boolean difMalAmbiente, String difOtra, String propuestasMejora) {
        this.respuestaId = respuestaId;
        this.resultado = resultado;
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
        this.difEscasoHabito = difEscasoHabito;
        this.difFaltaMotivacion = difFaltaMotivacion;
        this.difBajoNivel = difBajoNivel;
        this.difPocaColaboracion = difPocaColaboracion;
        this.difInfluenciaClima = difInfluenciaClima;
        this.difCarenciaMedios = difCarenciaMedios;
        this.difMalAmbiente = difMalAmbiente;
        this.difOtra = difOtra;
        this.propuestasMejora = propuestasMejora;
    }



    public Respuesta(int numeroAlumnosGrupo, int numeroAlumnosAprobados, boolean difEscasoHabito, boolean difFaltaMotivacion, boolean difBajoNivel, boolean difPocaColaboracion, boolean difInfluenciaClima, boolean difCarenciaMedios, boolean difMalAmbiente, String difOtra, String propuestasMejora) {
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
        this.difEscasoHabito = difEscasoHabito;
        this.difFaltaMotivacion = difFaltaMotivacion;
        this.difBajoNivel = difBajoNivel;
        this.difPocaColaboracion = difPocaColaboracion;
        this.difInfluenciaClima = difInfluenciaClima;
        this.difCarenciaMedios = difCarenciaMedios;
        this.difMalAmbiente = difMalAmbiente;
        this.difOtra = difOtra;
        this.propuestasMejora = propuestasMejora;
    }

    public Respuesta(Resultado resultado, int numeroAlumnosGrupo, int numeroAlumnosAprobados, boolean difEscasoHabito, boolean difFaltaMotivacion, boolean difBajoNivel, boolean difPocaColaboracion, boolean difInfluenciaClima, boolean difCarenciaMedios, boolean difMalAmbiente, String difOtra, String propuestasMejora) {
        this.resultado = resultado;
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
        this.difEscasoHabito = difEscasoHabito;
        this.difFaltaMotivacion = difFaltaMotivacion;
        this.difBajoNivel = difBajoNivel;
        this.difPocaColaboracion = difPocaColaboracion;
        this.difInfluenciaClima = difInfluenciaClima;
        this.difCarenciaMedios = difCarenciaMedios;
        this.difMalAmbiente = difMalAmbiente;
        this.difOtra = difOtra;
        this.propuestasMejora = propuestasMejora;
    }

    public Long getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(Long respuestaId) {
        this.respuestaId = respuestaId;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public int getNumeroAlumnosGrupo() {
        return numeroAlumnosGrupo;
    }

    public void setNumeroAlumnosGrupo(int numeroAlumnosGrupo) {
        this.numeroAlumnosGrupo = numeroAlumnosGrupo;
    }

    public int getNumeroAlumnosAprobados() {
        return numeroAlumnosAprobados;
    }

    public void setNumeroAlumnosAprobados(int numeroAlumnosAprobados) {
        this.numeroAlumnosAprobados = numeroAlumnosAprobados;
    }

    public boolean isDifEscasoHabito() {
        return difEscasoHabito;
    }

    public void setDifEscasoHabito(boolean difEscasoHabito) {
        this.difEscasoHabito = difEscasoHabito;
    }

    public boolean isDifFaltaMotivacion() {
        return difFaltaMotivacion;
    }

    public void setDifFaltaMotivacion(boolean difFaltaMotivacion) {
        this.difFaltaMotivacion = difFaltaMotivacion;
    }

    public boolean isDifBajoNivel() {
        return difBajoNivel;
    }

    public void setDifBajoNivel(boolean difBajoNivel) {
        this.difBajoNivel = difBajoNivel;
    }

    public boolean isDifPocaColaboracion() {
        return difPocaColaboracion;
    }

    public void setDifPocaColaboracion(boolean difPocaColaboracion) {
        this.difPocaColaboracion = difPocaColaboracion;
    }

    public boolean isDifInfluenciaClima() {
        return difInfluenciaClima;
    }

    public void setDifInfluenciaClima(boolean difInfluenciaClima) {
        this.difInfluenciaClima = difInfluenciaClima;
    }

    public boolean isDifCarenciaMedios() {
        return difCarenciaMedios;
    }

    public void setDifCarenciaMedios(boolean difCarenciaMedios) {
        this.difCarenciaMedios = difCarenciaMedios;
    }

    public boolean isDifMalAmbiente() {
        return difMalAmbiente;
    }

    public void setDifMalAmbiente(boolean difMalAmbiente) {
        this.difMalAmbiente = difMalAmbiente;
    }

    public String getDifOtra() {
        return difOtra;
    }

    public void setDifOtra(String difOtra) {
        this.difOtra = difOtra;
    }

    public String getPropuestasMejora() {
        return propuestasMejora;
    }

    public void setPropuestasMejora(String propuestasMejora) {
        this.propuestasMejora = propuestasMejora;
    }
}
