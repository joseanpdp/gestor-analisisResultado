package japdp.model.dto.response;

import java.util.List;

/**
 * DTO de respuesta que representa una asignatura.
 * Incluye los datos básicos, los temas y los resultados asociados.
 */
public class AsignaturaResponseDTO {

    /**
     * Identificador único de la asignatura.
     */
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
     */
    private List<TemaResumenResponseDTO> temas;

    /**
     * Lista de resultados asociados a la asignatura.
     */
    private List<ResultadoResumenResponseDTO> resultados;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public AsignaturaResponseDTO() {
    }

    /**
     * Constructor completo del DTO.
     *
     * @param asignaturaId Identificador de la asignatura
     * @param nombre Nombre de la asignatura
     * @param abreviatura Abreviatura de la asignatura
     * @param nivel Nivel educativo
     * @param temas Lista de temas asociados
     * @param resultados Lista de resultados asociados
     */
    public AsignaturaResponseDTO(
            Long asignaturaId,
            String nombre,
            String abreviatura,
            String nivel,
            List<TemaResumenResponseDTO> temas,
            List<ResultadoResumenResponseDTO> resultados
    ) {
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
     * @return Lista de temas asociados a la asignatura
     */
    public List<TemaResumenResponseDTO> getTemas() {
        return temas;
    }

    /**
     * @param temas Nueva lista de temas
     */
    public void setTemas(List<TemaResumenResponseDTO> temas) {
        this.temas = temas;
    }

    /**
     * @return Lista de resultados asociados a la asignatura
     */
    public List<ResultadoResumenResponseDTO> getResultados() {
        return resultados;
    }

    /**
     * @param resultados Nueva lista de resultados
     */
    public void setResultados(List<ResultadoResumenResponseDTO> resultados) {
        this.resultados = resultados;
    }
}