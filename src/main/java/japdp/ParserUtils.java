package japdp;

import japdp.model.*;
import japdp.model.dto.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidades para convertir entidades del modelo
 * en DTOs de respuesta.
 */
public class ParserUtils {

    /**
     * Logger utilizado para registrar información de ejecución.
     */
    private static final Logger log = LoggerFactory.getLogger(ParserUtils.class);

    /**
     * Convierte una entidad Tema en un DTO de respuesta.
     *
     * @param tema Entidad Tema
     * @return DTO de respuesta del tema
     */
    public static TemaResponseDTO temaToResponseDto(Tema tema) {
        TemaResponseDTO unidadDto = new TemaResponseDTO();
        unidadDto.setTemaId(tema.getTemaId());
        unidadDto.setNombre(tema.getNombre());
        AsignaturaResumenResponseDTO asignaturaDto = asignaturaToResumenResponseDto(tema.getAsignatura());
        unidadDto.setAsignatura(asignaturaDto);
        return unidadDto;
    }

    /**
     * Convierte una entidad Tema en un DTO de respuesta resumido.
     *
     * @param tema Entidad Tema
     * @return DTO de respuesta resumido del tema
     */
    public static TemaResumenResponseDTO temaToResumenResponseDto(Tema tema) {
        TemaResumenResponseDTO unidadDto = new TemaResumenResponseDTO();
        unidadDto.setTemaId(tema.getTemaId());
        unidadDto.setNombre(tema.getNombre());
        return unidadDto;
    }

    /**
     * Convierte una entidad Grupo en un DTO de respuesta.
     *
     * @param grupo Entidad Grupo
     * @return DTO de respuesta del grupo
     */
    public static GrupoResponseDTO grupoToResponseDto(Grupo grupo) {
        GrupoResponseDTO grupoDto = new GrupoResponseDTO();
        grupoDto.setGrupoId(grupo.getGrupoId());
        grupoDto.setNombre(grupo.getNombre());
        List<Resultado> resultados = grupo.getResultados();
        List<ResultadoResumenResponseDTO> resultadoDtos = new ArrayList<>();
        for (Resultado resultado : resultados) {
            ResultadoResumenResponseDTO resultadoDto = resultadoToResumenResponseDto(resultado);
            resultadoDtos.add(resultadoDto);
        }
        grupoDto.setResultados(resultadoDtos);
        return grupoDto;
    }

    /**
     * Convierte una entidad Grupo en un DTO de respuesta resumido.
     *
     * @param grupo Entidad Grupo
     * @return DTO de respuesta resumido del grupo
     */
    public static GrupoResumenResponseDTO grupoToResumenResponseDto(Grupo grupo) {
        GrupoResumenResponseDTO grupoDto = new GrupoResumenResponseDTO();
        grupoDto.setGrupoId(grupo.getGrupoId());
        grupoDto.setNombre(grupo.getNombre());
        return grupoDto;
    }

    /**
     * Convierte una entidad Docente en un DTO de respuesta.
     *
     * @param docente Entidad Docente
     * @return DTO de respuesta del docente
     */
    public static DocenteResponseDTO docenteToResponseDto(Docente docente) {
        DocenteResponseDTO docenteDto = new DocenteResponseDTO();
        docenteDto.setDocenteId(docente.getDocenteId());
        docenteDto.setNombre(docente.getNombre());
        List<Resultado> resultados = docente.getResultados();
        List<ResultadoResumenResponseDTO> resultadoDtos = new ArrayList<>();
        for (Resultado resultado : resultados) {
            ResultadoResumenResponseDTO resultadoDto = resultadoToResumenResponseDto(resultado);
            resultadoDtos.add(resultadoDto);
        }
        docenteDto.setResultados(resultadoDtos);
        return docenteDto;
    }

    /**
     * Convierte una entidad Docente en un DTO de respuesta resumido.
     *
     * @param docente Entidad Docente
     * @return DTO de respuesta resumido del docente
     */
    public static DocenteResumenResponseDTO docenteToResumenResponseDto(Docente docente) {
        DocenteResumenResponseDTO docenteDto = new DocenteResumenResponseDTO();
        docenteDto.setDocenteId(docente.getDocenteId());
        docenteDto.setNombre(docente.getNombre());
        return docenteDto;
    }

    /**
     * Convierte una entidad Asignatura en un DTO de respuesta resumido.
     *
     * @param asignatura Entidad Asignatura
     * @return DTO de respuesta resumido de la asignatura
     */
    public static AsignaturaResumenResponseDTO asignaturaToResumenResponseDto(Asignatura asignatura) {
        AsignaturaResumenResponseDTO asignaturaDto = new AsignaturaResumenResponseDTO();
        asignaturaDto.setAsignaturaId(asignatura.getAsignaturaId());
        asignaturaDto.setNombre(asignatura.getNombre());
        asignaturaDto.setAbreviatura(asignatura.getAbreviatura());
        asignaturaDto.setNivel(asignatura.getNivel());
        return asignaturaDto;
    }

    /**
     * Convierte una entidad Asignatura en un DTO de respuesta.
     *
     * @param asignatura Entidad Asignatura
     * @return DTO de respuesta de la asignatura
     */
    public static AsignaturaResponseDTO asignaturaToResponseDto(Asignatura asignatura) {
        AsignaturaResponseDTO asignaturaDto = new AsignaturaResponseDTO();
        asignaturaDto.setAsignaturaId(asignatura.getAsignaturaId());
        asignaturaDto.setNombre(asignatura.getNombre());
        asignaturaDto.setAbreviatura(asignatura.getAbreviatura());
        asignaturaDto.setNivel(asignatura.getNivel());
        List<Tema> temas = asignatura.getTemas();
        List<TemaResumenResponseDTO> temaDtos = new ArrayList<>();
        for (Tema tema : temas) {
            TemaResumenResponseDTO temaDto = temaToResumenResponseDto(tema);
            temaDtos.add(temaDto);
        }
        asignaturaDto.setTemas(temaDtos);
        List<Resultado> resultados = asignatura.getResultados();
        List<ResultadoResumenResponseDTO> resultadoDtos = new ArrayList<>();
        for (Resultado resultado : resultados) {
            ResultadoResumenResponseDTO resultadoDto = resultadoToResumenResponseDto(resultado);
            resultadoDtos.add(resultadoDto);
        }
        asignaturaDto.setResultados(resultadoDtos);
        return asignaturaDto;
    }

    /**
     * Convierte una entidad Resultado en un DTO de respuesta.
     *
     * @param resultado Entidad Resultado
     * @return DTO de respuesta del resultado
     */
    public static ResultadoResponseDTO resultadoToResponseDto(Resultado resultado) {
        ResultadoResponseDTO resultadoDto = new ResultadoResponseDTO();
        ResultadoId resultadoId = resultado.getResultadoId();
        ResultadoIdResponseDTO resultadoIdDto = new ResultadoIdResponseDTO();
        resultadoIdDto.setAsignaturaId(resultadoId.getAsignaturaId());
        resultadoIdDto.setDocenteId(resultadoId.getDocenteId());
        resultadoIdDto.setGrupoId(resultadoId.getGrupoId());
        resultadoDto.setResultadoId(resultadoIdDto);
        resultadoDto.setAsignatura(asignaturaToResumenResponseDto(resultado.getAsignatura()));
        resultadoDto.setDocente(docenteToResumenResponseDto(resultado.getDocente()));
        resultadoDto.setGrupo(grupoToResumenResponseDto(resultado.getGrupo()));
        if (resultado.getRespuesta() != null) {
            resultadoDto.setRespuesta(respuestaToResponseDto(resultado.getRespuesta()));
        }
        List<TemaResultado> temasResultados = resultado.getTemasResultados();
        List<TemaResultadoResponseDTO> temaResultadoDtos = new ArrayList<>();
        for (TemaResultado temaResultado : temasResultados) {
            TemaResultadoResponseDTO temaResultadoDto = temaResultadoToResponseDto(temaResultado);
            temaResultadoDtos.add(temaResultadoDto);
        }
        resultadoDto.setTemasResultados(temaResultadoDtos);
        return resultadoDto;
    }

    /**
     * Convierte una entidad Resultado en un DTO de respuesta resumido.
     *
     * @param resultado Entidad Resultado
     * @return DTO de respuesta resumido del resultado
     */
    public static ResultadoResumenResponseDTO resultadoToResumenResponseDto(Resultado resultado) {
        ResultadoResumenResponseDTO resultadoDto = new ResultadoResumenResponseDTO();
        ResultadoId resultadoId = resultado.getResultadoId();
        ResultadoIdResponseDTO resultadoIdDto = new ResultadoIdResponseDTO();
        resultadoIdDto.setAsignaturaId(resultadoId.getAsignaturaId());
        resultadoIdDto.setDocenteId(resultadoId.getDocenteId());
        resultadoIdDto.setGrupoId(resultadoId.getGrupoId());
        resultadoDto.setResultadoId(resultadoIdDto);
        return resultadoDto;
    }

    /**
     * Convierte una entidad TemaResultado en un DTO de respuesta.
     *
     * @param temaResultado Entidad TemaResultado
     * @return DTO de respuesta de la relación tema-resultado
     */
    public static TemaResultadoResponseDTO temaResultadoToResponseDto(TemaResultado temaResultado) {
        TemaResultadoResponseDTO temaResultadoDto = new TemaResultadoResponseDTO();
        TemaResultadoIdResponseDTO temaResultadoIdDto = new TemaResultadoIdResponseDTO();
        temaResultadoIdDto.setTemaId(temaResultado.getTemaResultadoId().getTemaId());
        ResultadoId resultadoId = temaResultado.getTemaResultadoId().getResultadoId();
        ResultadoIdResponseDTO resultadoIdDto = new ResultadoIdResponseDTO();
        resultadoIdDto.setDocenteId(resultadoId.getDocenteId());
        resultadoIdDto.setGrupoId(resultadoId.getGrupoId());
        resultadoIdDto.setAsignaturaId(resultadoId.getAsignaturaId());
        temaResultadoIdDto.setResultadoId(resultadoIdDto);
        temaResultadoDto.setTema(temaToResumenResponseDto(temaResultado.getTema()));
        temaResultadoDto.setDesarrollada(temaResultado.isDesarrollada());
        temaResultadoDto.setEvaluada(temaResultado.isEvaluada());
        temaResultadoDto.setObservaciones(temaResultado.getObservaciones());
        return temaResultadoDto;
    }

    /**
     * Convierte una entidad Respuesta en un DTO de respuesta.
     *
     * @param respuesta Entidad Respuesta
     * @return DTO de respuesta de la respuesta
     */
    public static RespuestaResponseDTO respuestaToResponseDto(Respuesta respuesta) {
        RespuestaResponseDTO respuestaDto = new RespuestaResponseDTO();
        respuestaDto.setRespuestaId(respuesta.getRespuestaId());
        ResultadoId resultadoId = respuesta.getResultado().getResultadoId();
        ResultadoIdResponseDTO resultadoIdDto = new ResultadoIdResponseDTO();
        resultadoIdDto.setAsignaturaId(resultadoId.getAsignaturaId());
        resultadoIdDto.setGrupoId(resultadoId.getGrupoId());
        resultadoIdDto.setDocenteId(resultadoId.getDocenteId());
        respuestaDto.setResultadoId(resultadoIdDto);
        respuestaDto.setNumeroAlumnosGrupo(respuesta.getNumeroAlumnosGrupo());
        respuestaDto.setNumeroAlumnosAprobados(respuesta.getNumeroAlumnosAprobados());
        respuestaDto.setDifEscasoHabito(respuesta.isDifEscasoHabito());
        respuestaDto.setDifFaltaMotivacion(respuesta.isDifFaltaMotivacion());
        respuestaDto.setDifBajoNivel(respuesta.isDifBajoNivel());
        respuestaDto.setDifPocaColaboracion(respuesta.isDifPocaColaboracion());
        respuestaDto.setDifInfluenciaClima(respuesta.isDifInfluenciaClima());
        respuestaDto.setDifCarenciaMedios(respuesta.isDifCarenciaMedios());
        respuestaDto.setDifMalAmiente(respuesta.isDifMalAmbiente());
        respuestaDto.setDifOtra(respuesta.getDifOtra());
        respuestaDto.setPropuestasMejora(respuesta.getPropuestasMejora());
        return respuestaDto;
    }
}