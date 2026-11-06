package japdp;

import jakarta.transaction.Transactional;
import japdp.model.*;
import japdp.repository.*;
import japdp.security.SecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExampleLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ExampleLoader.class);
    private final AsignaturaRepository asignaturaRepository;
    private final DocenteRepository docenteRepository;
    private final GrupoRepository grupoRepository;
    private final TemaRepository temaRepository;
    private final ResultadoRepository resultadoRepository;
    private final RespuestaRepository respuestaRepository;
    private final TemaResultadoRepository temaResultadoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public ExampleLoader(AsignaturaRepository asignaturaRepository, DocenteRepository docenteRepository, GrupoRepository grupoRepository, TemaRepository temaRepository, ResultadoRepository resultadoRepository, RespuestaRepository respuestaRepository, TemaResultadoRepository temaResultadoRepository, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.asignaturaRepository = asignaturaRepository;
        this.docenteRepository = docenteRepository;
        this.grupoRepository = grupoRepository;
        this.temaRepository = temaRepository;
        this.resultadoRepository = resultadoRepository;
        this.respuestaRepository = respuestaRepository;
        this.temaResultadoRepository = temaResultadoRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        /*Grupo grupoESO1A = new Grupo();
        grupoESO1A.setNombre("ESO1-A");
        Grupo grupoESO1B = new Grupo();
        grupoESO1B.setNombre("ESO1-B");
        Grupo grupoESO1C = new Grupo();
        grupoESO1C.setNombre("ESO1-C");
        Grupo grupoESO1D = new Grupo();
        grupoESO1D.setNombre("ESO1-D");

        Grupo grupoESO2A = new Grupo();
        grupoESO2A.setNombre("ESO2-A");
        Grupo grupoESO2B = new Grupo();
        grupoESO2B.setNombre("ESO2-B");
        Grupo grupoESO2C = new Grupo();
        grupoESO2C.setNombre("ESO2-C");
        Grupo grupoESO2D = new Grupo();
        grupoESO2D.setNombre("ESO2-D");

        Grupo grupoESO3A = new Grupo();
        grupoESO3A.setNombre("ESO3-A");
        Grupo grupoESO3B = new Grupo();
        grupoESO3B.setNombre("ESO3-B");
        Grupo grupoESO3C = new Grupo();
        grupoESO3C.setNombre("ESO3-C");
        Grupo grupoESO3D = new Grupo();
        grupoESO3D.setNombre("ESO3-D");

        Grupo grupoESO4A = new Grupo();
        grupoESO4A.setNombre("ESO4-A");
        Grupo grupoESO4B = new Grupo();
        grupoESO4B.setNombre("ESO4-B");
        Grupo grupoESO4C = new Grupo();
        grupoESO4C.setNombre("ESO4-C");
        Grupo grupoESO4D = new Grupo();
        grupoESO4D.setNombre("ESO4-D");

        Grupo grupoBach1A = new Grupo();
        grupoBach1A.setNombre("BACH1-A");
        Grupo grupoBach1B = new Grupo();
        grupoBach1B.setNombre("BACH1-B");
        Grupo grupoBach1C = new Grupo();
        grupoBach1C.setNombre("BACH1-C");
        Grupo grupoBach1D = new Grupo();
        grupoBach1D.setNombre("BACH1-D");

        Grupo grupoBach2A = new Grupo();
        grupoBach2A.setNombre("BACH2-A");
        Grupo grupoBach2B = new Grupo();
        grupoBach2B.setNombre("BACH2-B");
        Grupo grupoBach2C = new Grupo();
        grupoBach2C.setNombre("BACH2-C");
        Grupo grupoBach2D = new Grupo();
        grupoBach2D.setNombre("BACH2-D");

        grupoRepository.saveAll(List.of(
                grupoESO1A, grupoESO1B, grupoESO1C, grupoESO1D,
                grupoESO2A, grupoESO2B, grupoESO2C, grupoESO2D,
                grupoESO3A, grupoESO3B, grupoESO3C, grupoESO3D,
                grupoESO4A, grupoESO4B, grupoESO4C, grupoESO4D,
                grupoBach1A, grupoBach1B, grupoBach1C, grupoBach1D,
                grupoBach2A, grupoBach2B, grupoBach2C, grupoBach2D
        ));


        Asignatura lengua1 = new Asignatura();
        lengua1.setNombre("Lengua Castellana");
        lengua1.setAbreviatura("len");
        lengua1.setNivel("ESO1");
        lengua1.setTemas(new ArrayList<>());

        Asignatura lengua2 = new Asignatura();
        lengua2.setNombre("Lengua Castellana");
        lengua2.setAbreviatura("len");
        lengua2.setNivel("ESO2");
        lengua2.setTemas(new ArrayList<>());

        Asignatura lengua3 = new Asignatura();
        lengua3.setNombre("Lengua Castellana");
        lengua3.setAbreviatura("len");
        lengua3.setNivel("ESO3");
        lengua3.setTemas(new ArrayList<>());

        Asignatura lengua4 = new Asignatura();
        lengua4.setNombre("Lengua Castellana");
        lengua4.setAbreviatura("len");
        lengua4.setNivel("ESO4");
        lengua4.setTemas(new ArrayList<>());

        Asignatura lenguaBach1 = new Asignatura();
        lenguaBach1.setNombre("Lengua Castellana");
        lenguaBach1.setAbreviatura("len");
        lenguaBach1.setNivel("BACH1");
        lenguaBach1.setTemas(new ArrayList<>());

        Asignatura lenguaBach2 = new Asignatura();
        lenguaBach2.setNombre("Lengua Castellana");
        lenguaBach2.setAbreviatura("len");
        lenguaBach2.setNivel("BACH2");
        lenguaBach2.setTemas(new ArrayList<>());


        Asignatura matematicas1 = new Asignatura();
        matematicas1.setNombre("Matemáticas");
        matematicas1.setAbreviatura("mat");
        matematicas1.setNivel("ESO1");
        matematicas1.setTemas(new ArrayList<>());

        Asignatura matematicas2 = new Asignatura();
        matematicas2.setNombre("Matemáticas");
        matematicas2.setAbreviatura("mat");
        matematicas2.setNivel("ESO2");
        matematicas2.setTemas(new ArrayList<>());

        Asignatura matematicas3 = new Asignatura();
        matematicas3.setNombre("Matemáticas");
        matematicas3.setAbreviatura("mat");
        matematicas3.setNivel("ESO3");
        matematicas3.setTemas(new ArrayList<>());

        Asignatura matematicas4 = new Asignatura();
        matematicas4.setNombre("Matemáticas");
        matematicas4.setAbreviatura("mat");
        matematicas4.setNivel("ESO4");
        matematicas4.setTemas(new ArrayList<>());

        Asignatura matematicasBach1 = new Asignatura();
        matematicasBach1.setNombre("Matemáticas");
        matematicasBach1.setAbreviatura("mat");
        matematicasBach1.setNivel("BACH1");
        matematicasBach1.setTemas(new ArrayList<>());

        Asignatura matematicasBach2 = new Asignatura();
        matematicasBach2.setNombre("Matemáticas");
        matematicasBach2.setAbreviatura("mat");
        matematicasBach2.setNivel("BACH2");
        matematicasBach2.setTemas(new ArrayList<>());


        Asignatura historia1 = new Asignatura();
        historia1.setNombre("Historia");
        historia1.setAbreviatura("his");
        historia1.setNivel("ESO1");
        historia1.setTemas(new ArrayList<>());

        Asignatura historia2 = new Asignatura();
        historia2.setNombre("Historia");
        historia2.setAbreviatura("his");
        historia2.setNivel("ESO2");
        historia2.setTemas(new ArrayList<>());

        Asignatura historia3 = new Asignatura();
        historia3.setNombre("Historia");
        historia3.setAbreviatura("his");
        historia3.setNivel("ESO3");
        historia3.setTemas(new ArrayList<>());

        Asignatura historia4 = new Asignatura();
        historia4.setNombre("Historia");
        historia4.setAbreviatura("his");
        historia4.setNivel("ESO4");
        historia4.setTemas(new ArrayList<>());

        Asignatura historiaBach1 = new Asignatura();
        historiaBach1.setNombre("Historia");
        historiaBach1.setAbreviatura("his");
        historiaBach1.setNivel("BACH1");
        historiaBach1.setTemas(new ArrayList<>());

        Asignatura historiaBach2 = new Asignatura();
        historiaBach2.setNombre("Historia");
        historiaBach2.setAbreviatura("his");
        historiaBach2.setNivel("BACH2");
        historiaBach2.setTemas(new ArrayList<>());


        Asignatura fisica1 = new Asignatura();
        fisica1.setNombre("Física");
        fisica1.setAbreviatura("fis");
        fisica1.setNivel("ESO1");
        fisica1.setTemas(new ArrayList<>());

        Asignatura fisica2 = new Asignatura();
        fisica2.setNombre("Física");
        fisica2.setAbreviatura("fis");
        fisica2.setNivel("ESO2");
        fisica2.setTemas(new ArrayList<>());

        Asignatura fisica3 = new Asignatura();
        fisica3.setNombre("Física");
        fisica3.setAbreviatura("fis");
        fisica3.setNivel("ESO3");
        fisica3.setTemas(new ArrayList<>());

        Asignatura fisica4 = new Asignatura();
        fisica4.setNombre("Física");
        fisica4.setAbreviatura("fis");
        fisica4.setNivel("ESO4");
        fisica4.setTemas(new ArrayList<>());

        Asignatura fisicaBach1 = new Asignatura();
        fisicaBach1.setNombre("Física");
        fisicaBach1.setAbreviatura("fis");
        fisicaBach1.setNivel("BACH1");
        fisicaBach1.setTemas(new ArrayList<>());

        Asignatura fisicaBach2 = new Asignatura();
        fisicaBach2.setNombre("Física");
        fisicaBach2.setAbreviatura("fis");
        fisicaBach2.setNivel("BACH2");
        fisicaBach2.setTemas(new ArrayList<>());


        Asignatura ingles1 = new Asignatura();
        ingles1.setNombre("Inglés");
        ingles1.setAbreviatura("ing");
        ingles1.setNivel("ESO1");
        ingles1.setTemas(new ArrayList<>());

        Asignatura ingles2 = new Asignatura();
        ingles2.setNombre("Inglés");
        ingles2.setAbreviatura("ing");
        ingles2.setNivel("ESO2");
        ingles2.setTemas(new ArrayList<>());

        Asignatura ingles3 = new Asignatura();
        ingles3.setNombre("Inglés");
        ingles3.setAbreviatura("ing");
        ingles3.setNivel("ESO3");
        ingles3.setTemas(new ArrayList<>());

        Asignatura ingles4 = new Asignatura();
        ingles4.setNombre("Inglés");
        ingles4.setAbreviatura("ing");
        ingles4.setNivel("ESO4");
        ingles4.setTemas(new ArrayList<>());

        Asignatura inglesBach1 = new Asignatura();
        inglesBach1.setNombre("Inglés");
        inglesBach1.setAbreviatura("ing");
        inglesBach1.setNivel("BACH1");
        inglesBach1.setTemas(new ArrayList<>());

        Asignatura inglesBach2 = new Asignatura();
        inglesBach2.setNombre("Inglés");
        inglesBach2.setAbreviatura("ing");
        inglesBach2.setNivel("BACH2");
        inglesBach2.setTemas(new ArrayList<>());


        Asignatura biologia1 = new Asignatura();
        biologia1.setNombre("Biología");
        biologia1.setAbreviatura("bio");
        biologia1.setNivel("ESO1");
        biologia1.setTemas(new ArrayList<>());

        Asignatura biologia2 = new Asignatura();
        biologia2.setNombre("Biología");
        biologia2.setAbreviatura("bio");
        biologia2.setNivel("ESO2");
        biologia2.setTemas(new ArrayList<>());

        Asignatura biologia3 = new Asignatura();
        biologia3.setNombre("Biología");
        biologia3.setAbreviatura("bio");
        biologia3.setNivel("ESO3");
        biologia3.setTemas(new ArrayList<>());

        Asignatura biologia4 = new Asignatura();
        biologia4.setNombre("Biología");
        biologia4.setAbreviatura("bio");
        biologia4.setNivel("ESO4");
        biologia4.setTemas(new ArrayList<>());

        Asignatura biologiaBach1 = new Asignatura();
        biologiaBach1.setNombre("Biología");
        biologiaBach1.setAbreviatura("bio");
        biologiaBach1.setNivel("BACH1");
        biologiaBach1.setTemas(new ArrayList<>());

        Asignatura biologiaBach2 = new Asignatura();
        biologiaBach2.setNombre("Biología");
        biologiaBach2.setAbreviatura("bio");
        biologiaBach2.setNivel("BACH2");
        biologiaBach2.setTemas(new ArrayList<>());


        asignaturaRepository.saveAll(List.of(
                lengua1, lengua2, lengua3, lengua4, lenguaBach1, lenguaBach2,
                matematicas1, matematicas2, matematicas3, matematicas4,
                matematicasBach1, matematicasBach2,
                historia1, historia2, historia3, historia4, historiaBach1, historiaBach2,
                fisica1, fisica2, fisica3, fisica4, fisicaBach1, fisicaBach2,
                ingles1, ingles2, ingles3, ingles4, inglesBach1, inglesBach2,
                biologia1, biologia2, biologia3, biologia4, biologiaBach1, biologiaBach2
        ));


        Tema tema1Lengua1 = new Tema();
        tema1Lengua1.setNombre("Unidad 1 - Comunicación");
        tema1Lengua1.setAsignatura(lengua1);
        Tema tema2Lengua1 = new Tema();
        tema2Lengua1.setNombre("Unidad 2 - Gramática");
        tema2Lengua1.setAsignatura(lengua1);
        Tema tema3Lengua1 = new Tema();
        tema3Lengua1.setNombre("Unidad 3 - Ortografía");
        tema3Lengua1.setAsignatura(lengua1);
        Tema tema4Lengua1 = new Tema();
        tema4Lengua1.setNombre("Unidad 4 - Literatura");
        tema4Lengua1.setAsignatura(lengua1);
        Tema tema5Lengua1 = new Tema();
        tema5Lengua1.setNombre("Unidad 5 - Expresión escrita");
        tema5Lengua1.setAsignatura(lengua1);

        Tema tema1Lengua2 = new Tema();
        tema1Lengua2.setNombre("Unidad 1 - Comunicación");
        tema1Lengua2.setAsignatura(lengua2);
        Tema tema2Lengua2 = new Tema();
        tema2Lengua2.setNombre("Unidad 2 - Gramática");
        tema2Lengua2.setAsignatura(lengua2);
        Tema tema3Lengua2 = new Tema();
        tema3Lengua2.setNombre("Unidad 3 - Ortografía");
        tema3Lengua2.setAsignatura(lengua2);
        Tema tema4Lengua2 = new Tema();
        tema4Lengua2.setNombre("Unidad 4 - Literatura");
        tema4Lengua2.setAsignatura(lengua2);
        Tema tema5Lengua2 = new Tema();
        tema5Lengua2.setNombre("Unidad 5 - Expresión escrita");
        tema5Lengua2.setAsignatura(lengua2);

        Tema tema1Lengua3 = new Tema();
        tema1Lengua3.setNombre("Unidad 1 - Comunicación");
        tema1Lengua3.setAsignatura(lengua3);
        Tema tema2Lengua3 = new Tema();
        tema2Lengua3.setNombre("Unidad 2 - Gramática");
        tema2Lengua3.setAsignatura(lengua3);
        Tema tema3Lengua3 = new Tema();
        tema3Lengua3.setNombre("Unidad 3 - Ortografía");
        tema3Lengua3.setAsignatura(lengua3);
        Tema tema4Lengua3 = new Tema();
        tema4Lengua3.setNombre("Unidad 4 - Literatura");
        tema4Lengua3.setAsignatura(lengua3);
        Tema tema5Lengua3 = new Tema();
        tema5Lengua3.setNombre("Unidad 5 - Expresión escrita");
        tema5Lengua3.setAsignatura(lengua3);

        Tema tema1Lengua4 = new Tema();
        tema1Lengua4.setNombre("Unidad 1 - Comunicación");
        tema1Lengua4.setAsignatura(lengua4);
        Tema tema2Lengua4 = new Tema();
        tema2Lengua4.setNombre("Unidad 2 - Gramática");
        tema2Lengua4.setAsignatura(lengua4);
        Tema tema3Lengua4 = new Tema();
        tema3Lengua4.setNombre("Unidad 3 - Ortografía");
        tema3Lengua4.setAsignatura(lengua4);
        Tema tema4Lengua4 = new Tema();
        tema4Lengua4.setNombre("Unidad 4 - Literatura");
        tema4Lengua4.setAsignatura(lengua4);
        Tema tema5Lengua4 = new Tema();
        tema5Lengua4.setNombre("Unidad 5 - Expresión escrita");
        tema5Lengua4.setAsignatura(lengua4);

        Tema tema1LenguaBach1 = new Tema();
        tema1LenguaBach1.setNombre("Unidad 1 - Sintaxis");
        tema1LenguaBach1.setAsignatura(lenguaBach1);
        Tema tema2LenguaBach1 = new Tema();
        tema2LenguaBach1.setNombre("Unidad 2 - Literatura medieval");
        tema2LenguaBach1.setAsignatura(lenguaBach1);
        Tema tema3LenguaBach1 = new Tema();
        tema3LenguaBach1.setNombre("Unidad 3 - Renacimiento");
        tema3LenguaBach1.setAsignatura(lenguaBach1);
        Tema tema4LenguaBach1 = new Tema();
        tema4LenguaBach1.setNombre("Unidad 4 - Comentario de texto");
        tema4LenguaBach1.setAsignatura(lenguaBach1);
        Tema tema5LenguaBach1 = new Tema();
        tema5LenguaBach1.setNombre("Unidad 5 - Argumentación");
        tema5LenguaBach1.setAsignatura(lenguaBach1);

        Tema tema1LenguaBach2 = new Tema();
        tema1LenguaBach2.setNombre("Unidad 1 - Literatura contemporánea");
        tema1LenguaBach2.setAsignatura(lenguaBach2);
        Tema tema2LenguaBach2 = new Tema();
        tema2LenguaBach2.setNombre("Unidad 2 - Sintaxis avanzada");
        tema2LenguaBach2.setAsignatura(lenguaBach2);
        Tema tema3LenguaBach2 = new Tema();
        tema3LenguaBach2.setNombre("Unidad 3 - Comentario crítico");
        tema3LenguaBach2.setAsignatura(lenguaBach2);
        Tema tema4LenguaBach2 = new Tema();
        tema4LenguaBach2.setNombre("Unidad 4 - Teatro español");
        tema4LenguaBach2.setAsignatura(lenguaBach2);
        Tema tema5LenguaBach2 = new Tema();
        tema5LenguaBach2.setNombre("Unidad 5 - Poesía española");
        tema5LenguaBach2.setAsignatura(lenguaBach2);


        Tema tema1Matematicas1 = new Tema();
        tema1Matematicas1.setNombre("Unidad 1 - Números");
        tema1Matematicas1.setAsignatura(matematicas1);
        Tema tema2Matematicas1 = new Tema();
        tema2Matematicas1.setNombre("Unidad 2 - Álgebra");
        tema2Matematicas1.setAsignatura(matematicas1);
        Tema tema3Matematicas1 = new Tema();
        tema3Matematicas1.setNombre("Unidad 3 - Geometría");
        tema3Matematicas1.setAsignatura(matematicas1);
        Tema tema4Matematicas1 = new Tema();
        tema4Matematicas1.setNombre("Unidad 4 - Proporcionalidad");
        tema4Matematicas1.setAsignatura(matematicas1);
        Tema tema5Matematicas1 = new Tema();
        tema5Matematicas1.setNombre("Unidad 5 - Estadística");
        tema5Matematicas1.setAsignatura(matematicas1);

        Tema tema1Matematicas2 = new Tema();
        tema1Matematicas2.setNombre("Unidad 1 - Números enteros");
        tema1Matematicas2.setAsignatura(matematicas2);
        Tema tema2Matematicas2 = new Tema();
        tema2Matematicas2.setNombre("Unidad 2 - Ecuaciones");
        tema2Matematicas2.setAsignatura(matematicas2);
        Tema tema3Matematicas2 = new Tema();
        tema3Matematicas2.setNombre("Unidad 3 - Funciones");
        tema3Matematicas2.setAsignatura(matematicas2);
        Tema tema4Matematicas2 = new Tema();
        tema4Matematicas2.setNombre("Unidad 4 - Geometría");
        tema4Matematicas2.setAsignatura(matematicas2);
        Tema tema5Matematicas2 = new Tema();
        tema5Matematicas2.setNombre("Unidad 5 - Probabilidad");
        tema5Matematicas2.setAsignatura(matematicas2);

        Tema tema1Matematicas3 = new Tema();
        tema1Matematicas3.setNombre("Unidad 1 - Potencias");
        tema1Matematicas3.setAsignatura(matematicas3);
        Tema tema2Matematicas3 = new Tema();
        tema2Matematicas3.setNombre("Unidad 2 - Polinomios");
        tema2Matematicas3.setAsignatura(matematicas3);
        Tema tema3Matematicas3 = new Tema();
        tema3Matematicas3.setNombre("Unidad 3 - Ecuaciones");
        tema3Matematicas3.setAsignatura(matematicas3);
        Tema tema4Matematicas3 = new Tema();
        tema4Matematicas3.setNombre("Unidad 4 - Trigonometría");
        tema4Matematicas3.setAsignatura(matematicas3);
        Tema tema5Matematicas3 = new Tema();
        tema5Matematicas3.setNombre("Unidad 5 - Estadística");
        tema5Matematicas3.setAsignatura(matematicas3);

        Tema tema1Matematicas4 = new Tema();
        tema1Matematicas4.setNombre("Unidad 1 - Números reales");
        tema1Matematicas4.setAsignatura(matematicas4);
        Tema tema2Matematicas4 = new Tema();
        tema2Matematicas4.setNombre("Unidad 2 - Funciones");
        tema2Matematicas4.setAsignatura(matematicas4);
        Tema tema3Matematicas4 = new Tema();
        tema3Matematicas4.setNombre("Unidad 3 - Geometría analítica");
        tema3Matematicas4.setAsignatura(matematicas4);
        Tema tema4Matematicas4 = new Tema();
        tema4Matematicas4.setNombre("Unidad 4 - Probabilidad");
        tema4Matematicas4.setAsignatura(matematicas4);
        Tema tema5Matematicas4 = new Tema();
        tema5Matematicas4.setNombre("Unidad 5 - Estadística");
        tema5Matematicas4.setAsignatura(matematicas4);

        Tema tema1MatematicasBach1 = new Tema();
        tema1MatematicasBach1.setNombre("Unidad 1 - Límites");
        tema1MatematicasBach1.setAsignatura(matematicasBach1);
        Tema tema2MatematicasBach1 = new Tema();
        tema2MatematicasBach1.setNombre("Unidad 2 - Derivadas");
        tema2MatematicasBach1.setAsignatura(matematicasBach1);
        Tema tema3MatematicasBach1 = new Tema();
        tema3MatematicasBach1.setNombre("Unidad 3 - Integrales");
        tema3MatematicasBach1.setAsignatura(matematicasBach1);
        Tema tema4MatematicasBach1 = new Tema();
        tema4MatematicasBach1.setNombre("Unidad 4 - Probabilidad");
        tema4MatematicasBach1.setAsignatura(matematicasBach1);
        Tema tema5MatematicasBach1 = new Tema();
        tema5MatematicasBach1.setNombre("Unidad 5 - Geometría");
        tema5MatematicasBach1.setAsignatura(matematicasBach1);

        Tema tema1MatematicasBach2 = new Tema();
        tema1MatematicasBach2.setNombre("Unidad 1 - Álgebra");
        tema1MatematicasBach2.setAsignatura(matematicasBach2);
        Tema tema2MatematicasBach2 = new Tema();
        tema2MatematicasBach2.setNombre("Unidad 2 - Derivadas");
        tema2MatematicasBach2.setAsignatura(matematicasBach2);
        Tema tema3MatematicasBach2 = new Tema();
        tema3MatematicasBach2.setNombre("Unidad 3 - Integrales");
        tema3MatematicasBach2.setAsignatura(matematicasBach2);
        Tema tema4MatematicasBach2 = new Tema();
        tema4MatematicasBach2.setNombre("Unidad 4 - Probabilidad");
        tema4MatematicasBach2.setAsignatura(matematicasBach2);
        Tema tema5MatematicasBach2 = new Tema();
        tema5MatematicasBach2.setNombre("Unidad 5 - Estadística");
        tema5MatematicasBach2.setAsignatura(matematicasBach2);
        Tema tema1Historia1 = new Tema();
        tema1Historia1.setNombre("Unidad 1 - Prehistoria");
        tema1Historia1.setAsignatura(historia1);
        Tema tema2Historia1 = new Tema();
        tema2Historia1.setNombre("Unidad 2 - Edad Antigua");
        tema2Historia1.setAsignatura(historia1);
        Tema tema3Historia1 = new Tema();
        tema3Historia1.setNombre("Unidad 3 - Grecia");
        tema3Historia1.setAsignatura(historia1);
        Tema tema4Historia1 = new Tema();
        tema4Historia1.setNombre("Unidad 4 - Roma");
        tema4Historia1.setAsignatura(historia1);
        Tema tema5Historia1 = new Tema();
        tema5Historia1.setNombre("Unidad 5 - Hispania");
        tema5Historia1.setAsignatura(historia1);

        Tema tema1Historia2 = new Tema();
        tema1Historia2.setNombre("Unidad 1 - Edad Media");
        tema1Historia2.setAsignatura(historia2);
        Tema tema2Historia2 = new Tema();
        tema2Historia2.setNombre("Unidad 2 - Al-Ándalus");
        tema2Historia2.setAsignatura(historia2);
        Tema tema3Historia2 = new Tema();
        tema3Historia2.setNombre("Unidad 3 - Reinos cristianos");
        tema3Historia2.setAsignatura(historia2);
        Tema tema4Historia2 = new Tema();
        tema4Historia2.setNombre("Unidad 4 - La Reconquista");
        tema4Historia2.setAsignatura(historia2);
        Tema tema5Historia2 = new Tema();
        tema5Historia2.setNombre("Unidad 5 - La Edad Moderna");
        tema5Historia2.setAsignatura(historia2);

        Tema tema1Historia3 = new Tema();
        tema1Historia3.setNombre("Unidad 1 - Renacimiento");
        tema1Historia3.setAsignatura(historia3);
        Tema tema2Historia3 = new Tema();
        tema2Historia3.setNombre("Unidad 2 - Reforma protestante");
        tema2Historia3.setAsignatura(historia3);
        Tema tema3Historia3 = new Tema();
        tema3Historia3.setNombre("Unidad 3 - Monarquías absolutas");
        tema3Historia3.setAsignatura(historia3);
        Tema tema4Historia3 = new Tema();
        tema4Historia3.setNombre("Unidad 4 - Ilustración");
        tema4Historia3.setAsignatura(historia3);
        Tema tema5Historia3 = new Tema();
        tema5Historia3.setNombre("Unidad 5 - Revoluciones");
        tema5Historia3.setAsignatura(historia3);

        Tema tema1Historia4 = new Tema();
        tema1Historia4.setNombre("Unidad 1 - Revolución Industrial");
        tema1Historia4.setAsignatura(historia4);
        Tema tema2Historia4 = new Tema();
        tema2Historia4.setNombre("Unidad 2 - Imperialismo");
        tema2Historia4.setAsignatura(historia4);
        Tema tema3Historia4 = new Tema();
        tema3Historia4.setNombre("Unidad 3 - Primera Guerra Mundial");
        tema3Historia4.setAsignatura(historia4);
        Tema tema4Historia4 = new Tema();
        tema4Historia4.setNombre("Unidad 4 - Guerra Civil española");
        tema4Historia4.setAsignatura(historia4);
        Tema tema5Historia4 = new Tema();
        tema5Historia4.setNombre("Unidad 5 - Segunda Guerra Mundial");
        tema5Historia4.setAsignatura(historia4);

        Tema tema1HistoriaBach1 = new Tema();
        tema1HistoriaBach1.setNombre("Unidad 1 - Crisis del Antiguo Régimen");
        tema1HistoriaBach1.setAsignatura(historiaBach1);
        Tema tema2HistoriaBach1 = new Tema();
        tema2HistoriaBach1.setNombre("Unidad 2 - Liberalismo");
        tema2HistoriaBach1.setAsignatura(historiaBach1);
        Tema tema3HistoriaBach1 = new Tema();
        tema3HistoriaBach1.setNombre("Unidad 3 - Revolución Industrial");
        tema3HistoriaBach1.setAsignatura(historiaBach1);
        Tema tema4HistoriaBach1 = new Tema();
        tema4HistoriaBach1.setNombre("Unidad 4 - Colonialismo");
        tema4HistoriaBach1.setAsignatura(historiaBach1);
        Tema tema5HistoriaBach1 = new Tema();
        tema5HistoriaBach1.setNombre("Unidad 5 - España contemporánea");
        tema5HistoriaBach1.setAsignatura(historiaBach1);

        Tema tema1HistoriaBach2 = new Tema();
        tema1HistoriaBach2.setNombre("Unidad 1 - Restauración borbónica");
        tema1HistoriaBach2.setAsignatura(historiaBach2);
        Tema tema2HistoriaBach2 = new Tema();
        tema2HistoriaBach2.setNombre("Unidad 2 - Segunda República");
        tema2HistoriaBach2.setAsignatura(historiaBach2);
        Tema tema3HistoriaBach2 = new Tema();
        tema3HistoriaBach2.setNombre("Unidad 3 - Guerra Civil");
        tema3HistoriaBach2.setAsignatura(historiaBach2);
        Tema tema4HistoriaBach2 = new Tema();
        tema4HistoriaBach2.setNombre("Unidad 4 - Dictadura franquista");
        tema4HistoriaBach2.setAsignatura(historiaBach2);
        Tema tema5HistoriaBach2 = new Tema();
        tema5HistoriaBach2.setNombre("Unidad 5 - Transición democrática");
        tema5HistoriaBach2.setAsignatura(historiaBach2);

        Tema tema1Fisica1 = new Tema();
        tema1Fisica1.setNombre("Unidad 1 - La materia");
        tema1Fisica1.setAsignatura(fisica1);
        Tema tema2Fisica1 = new Tema();
        tema2Fisica1.setNombre("Unidad 2 - Movimiento");
        tema2Fisica1.setAsignatura(fisica1);
        Tema tema3Fisica1 = new Tema();
        tema3Fisica1.setNombre("Unidad 3 - Fuerzas");
        tema3Fisica1.setAsignatura(fisica1);
        Tema tema4Fisica1 = new Tema();
        tema4Fisica1.setNombre("Unidad 4 - Energía");
        tema4Fisica1.setAsignatura(fisica1);
        Tema tema5Fisica1 = new Tema();
        tema5Fisica1.setNombre("Unidad 5 - Electricidad");
        tema5Fisica1.setAsignatura(fisica1);

        Tema tema1Fisica2 = new Tema();
        tema1Fisica2.setNombre("Unidad 1 - Cinemática");
        tema1Fisica2.setAsignatura(fisica2);
        Tema tema2Fisica2 = new Tema();
        tema2Fisica2.setNombre("Unidad 2 - Dinámica");
        tema2Fisica2.setAsignatura(fisica2);
        Tema tema3Fisica2 = new Tema();
        tema3Fisica2.setNombre("Unidad 3 - Trabajo");
        tema3Fisica2.setAsignatura(fisica2);
        Tema tema4Fisica2 = new Tema();
        tema4Fisica2.setNombre("Unidad 4 - Calor");
        tema4Fisica2.setAsignatura(fisica2);
        Tema tema5Fisica2 = new Tema();
        tema5Fisica2.setNombre("Unidad 5 - Ondas");
        tema5Fisica2.setAsignatura(fisica2);

        Tema tema1Fisica3 = new Tema();
        tema1Fisica3.setNombre("Unidad 1 - Movimiento rectilíneo");
        tema1Fisica3.setAsignatura(fisica3);
        Tema tema2Fisica3 = new Tema();
        tema2Fisica3.setNombre("Unidad 2 - Leyes de Newton");
        tema2Fisica3.setAsignatura(fisica3);
        Tema tema3Fisica3 = new Tema();
        tema3Fisica3.setNombre("Unidad 3 - Gravitación");
        tema3Fisica3.setAsignatura(fisica3);
        Tema tema4Fisica3 = new Tema();
        tema4Fisica3.setNombre("Unidad 4 - Fluidos");
        tema4Fisica3.setAsignatura(fisica3);
        Tema tema5Fisica3 = new Tema();
        tema5Fisica3.setNombre("Unidad 5 - Electricidad");
        tema5Fisica3.setAsignatura(fisica3);

        Tema tema1Fisica4 = new Tema();
        tema1Fisica4.setNombre("Unidad 1 - Electromagnetismo");
        tema1Fisica4.setAsignatura(fisica4);
        Tema tema2Fisica4 = new Tema();
        tema2Fisica4.setNombre("Unidad 2 - Óptica");
        tema2Fisica4.setAsignatura(fisica4);
        Tema tema3Fisica4 = new Tema();
        tema3Fisica4.setNombre("Unidad 3 - Energía");
        tema3Fisica4.setAsignatura(fisica4);
        Tema tema4Fisica4 = new Tema();
        tema4Fisica4.setNombre("Unidad 4 - Física moderna");
        tema4Fisica4.setAsignatura(fisica4);
        Tema tema5Fisica4 = new Tema();
        tema5Fisica4.setNombre("Unidad 5 - Tecnología");
        tema5Fisica4.setAsignatura(fisica4);

        Tema tema1FisicaBach1 = new Tema();
        tema1FisicaBach1.setNombre("Unidad 1 - Vectores");
        tema1FisicaBach1.setAsignatura(fisicaBach1);
        Tema tema2FisicaBach1 = new Tema();
        tema2FisicaBach1.setNombre("Unidad 2 - Mecánica");
        tema2FisicaBach1.setAsignatura(fisicaBach1);
        Tema tema3FisicaBach1 = new Tema();
        tema3FisicaBach1.setNombre("Unidad 3 - Campo gravitatorio");
        tema3FisicaBach1.setAsignatura(fisicaBach1);
        Tema tema4FisicaBach1 = new Tema();
        tema4FisicaBach1.setNombre("Unidad 4 - Campo eléctrico");
        tema4FisicaBach1.setAsignatura(fisicaBach1);
        Tema tema5FisicaBach1 = new Tema();
        tema5FisicaBach1.setNombre("Unidad 5 - Termodinámica");
        tema5FisicaBach1.setAsignatura(fisicaBach1);

        Tema tema1FisicaBach2 = new Tema();
        tema1FisicaBach2.setNombre("Unidad 1 - Ondas");
        tema1FisicaBach2.setAsignatura(fisicaBach2);
        Tema tema2FisicaBach2 = new Tema();
        tema2FisicaBach2.setNombre("Unidad 2 - Óptica");
        tema2FisicaBach2.setAsignatura(fisicaBach2);
        Tema tema3FisicaBach2 = new Tema();
        tema3FisicaBach2.setNombre("Unidad 3 - Relatividad");
        tema3FisicaBach2.setAsignatura(fisicaBach2);
        Tema tema4FisicaBach2 = new Tema();
        tema4FisicaBach2.setNombre("Unidad 4 - Física cuántica");
        tema4FisicaBach2.setAsignatura(fisicaBach2);
        Tema tema5FisicaBach2 = new Tema();
        tema5FisicaBach2.setNombre("Unidad 5 - Física nuclear");
        tema5FisicaBach2.setAsignatura(fisicaBach2);

        temaRepository.saveAll(List.of(
                tema1Lengua1, tema2Lengua1, tema3Lengua1, tema4Lengua1, tema5Lengua1,
                tema1Lengua2, tema2Lengua2, tema3Lengua2, tema4Lengua2, tema5Lengua2,
                tema1Lengua3, tema2Lengua3, tema3Lengua3, tema4Lengua3, tema5Lengua3,
                tema1Lengua4, tema2Lengua4, tema3Lengua4, tema4Lengua4, tema5Lengua4,
                tema1LenguaBach1, tema2LenguaBach1, tema3LenguaBach1,
                tema4LenguaBach1, tema5LenguaBach1,
                tema1LenguaBach2, tema2LenguaBach2, tema3LenguaBach2,
                tema4LenguaBach2, tema5LenguaBach2,

                tema1Matematicas1, tema2Matematicas1, tema3Matematicas1,
                tema4Matematicas1, tema5Matematicas1,
                tema1Matematicas2, tema2Matematicas2, tema3Matematicas2,
                tema4Matematicas2, tema5Matematicas2,
                tema1Matematicas3, tema2Matematicas3, tema3Matematicas3,
                tema4Matematicas3, tema5Matematicas3,
                tema1Matematicas4, tema2Matematicas4, tema3Matematicas4,
                tema4Matematicas4, tema5Matematicas4,
                tema1MatematicasBach1, tema2MatematicasBach1,
                tema3MatematicasBach1, tema4MatematicasBach1, tema5MatematicasBach1,
                tema1MatematicasBach2, tema2MatematicasBach2,
                tema3MatematicasBach2, tema4MatematicasBach2, tema5MatematicasBach2,

                tema1Historia1, tema2Historia1, tema3Historia1,
                tema4Historia1, tema5Historia1,
                tema1Historia2, tema2Historia2, tema3Historia2,
                tema4Historia2, tema5Historia2,
                tema1Historia3, tema2Historia3, tema3Historia3,
                tema4Historia3, tema5Historia3,
                tema1Historia4, tema2Historia4, tema3Historia4,
                tema4Historia4, tema5Historia4,
                tema1HistoriaBach1, tema2HistoriaBach1, tema3HistoriaBach1,
                tema4HistoriaBach1, tema5HistoriaBach1,
                tema1HistoriaBach2, tema2HistoriaBach2, tema3HistoriaBach2,
                tema4HistoriaBach2, tema5HistoriaBach2,

                tema1Fisica1, tema2Fisica1, tema3Fisica1, tema4Fisica1, tema5Fisica1,
                tema1Fisica2, tema2Fisica2, tema3Fisica2, tema4Fisica2, tema5Fisica2,
                tema1Fisica3, tema2Fisica3, tema3Fisica3, tema4Fisica3, tema5Fisica3,
                tema1Fisica4, tema2Fisica4, tema3Fisica4, tema4Fisica4, tema5Fisica4,
                tema1FisicaBach1, tema2FisicaBach1, tema3FisicaBach1,
                tema4FisicaBach1, tema5FisicaBach1,
                tema1FisicaBach2, tema2FisicaBach2, tema3FisicaBach2,
                tema4FisicaBach2, tema5FisicaBach2
        ));

        Usuario anaUsuario = new Usuario();
        anaUsuario.setUsername("angalo");
        anaUsuario.setPassword(passwordEncoder.encode("123"));
        anaUsuario.setRole(Role.ADMIN);

        Usuario luisUsuario = new Usuario();
        luisUsuario.setUsername("lumasa");
        luisUsuario.setPassword(passwordEncoder.encode("123"));
        luisUsuario.setRole(Role.USER);

        Usuario martaUsuario = new Usuario();
        martaUsuario.setUsername("maferu");
        martaUsuario.setPassword(passwordEncoder.encode("123"));
        martaUsuario.setRole(Role.USER);

        Usuario carlosUsuario = new Usuario();
        carlosUsuario.setUsername("cogona");
        carlosUsuario.setPassword(passwordEncoder.encode("123"));
        carlosUsuario.setRole(Role.USER);

        Usuario lauraUsuario = new Usuario();
        lauraUsuario.setUsername("ladimo");
        lauraUsuario.setPassword(passwordEncoder.encode("123"));
        lauraUsuario.setRole(Role.USER);

        Usuario javierUsuario = new Usuario();
        javierUsuario.setUsername("jaroto");
        javierUsuario.setPassword(passwordEncoder.encode("123"));
        javierUsuario.setRole(Role.USER);

        Usuario elenaUsuario = new Usuario();
        elenaUsuario.setUsername("elvamo");
        elenaUsuario.setPassword(passwordEncoder.encode("123"));
        elenaUsuario.setRole(Role.USER);

        Usuario davidUsuario = new Usuario();
        davidUsuario.setUsername("daorca");
        davidUsuario.setPassword(passwordEncoder.encode("123"));
        davidUsuario.setRole(Role.USER);

        Usuario saraUsuario = new Usuario();
        saraUsuario.setUsername("sanaig");
        saraUsuario.setPassword(passwordEncoder.encode("123"));
        saraUsuario.setRole(Role.USER);

        Usuario pabloUsuario = new Usuario();
        pabloUsuario.setUsername("paserve");
        pabloUsuario.setPassword(passwordEncoder.encode("123"));
        pabloUsuario.setRole(Role.USER);

        usuarioRepository.saveAll(List.of(
                anaUsuario,
                luisUsuario,
                martaUsuario,
                carlosUsuario,
                lauraUsuario,
                javierUsuario,
                elenaUsuario,
                davidUsuario,
                saraUsuario,
                pabloUsuario
        ));


        Docente ana = new Docente();
        ana.setNombre("Ana García López");
        ana.setUsuario(anaUsuario);

        Docente luis = new Docente();
        luis.setNombre("Luis Martínez Sánchez");
        luis.setUsuario(luisUsuario);

        Docente marta = new Docente();
        marta.setNombre("Marta Fernández Ruiz");
        marta.setUsuario(martaUsuario);

        Docente carlos = new Docente();
        carlos.setNombre("Carlos Gómez Navarro");
        carlos.setUsuario(carlosUsuario);

        Docente laura = new Docente();
        laura.setNombre("Laura Díaz Moreno");
        laura.setUsuario(lauraUsuario);

        Docente javier = new Docente();
        javier.setNombre("Javier Romero Torres");
        javier.setUsuario(javierUsuario);

        Docente elena = new Docente();
        elena.setNombre("Elena Vázquez Molina");
        elena.setUsuario(elenaUsuario);

        Docente david = new Docente();
        david.setNombre("David Ortega Castro");
        david.setUsuario(davidUsuario);

        Docente sara = new Docente();
        sara.setNombre("Sara Navarro Iglesias");
        sara.setUsuario(saraUsuario);

        Docente pablo = new Docente();
        pablo.setNombre("Pablo Serrano Vega");
        pablo.setUsuario(pabloUsuario);

        docenteRepository.saveAll(List.of(
                ana,
                luis,
                marta,
                carlos,
                laura,
                javier,
                elena,
                david,
                sara,
                pablo
        ));

        Resultado resultadoLengua1AnaESO1A =
                new Resultado(lengua1, ana, grupoESO1A);

        Resultado resultadoLengua1AnaESO1B =
                new Resultado(lengua1, ana, grupoESO1B);

        Resultado resultadoLengua1AnaESO1C =
                new Resultado(lengua1, ana, grupoESO1C);

        Resultado resultadoLengua1AnaESO1D =
                new Resultado(lengua1, ana, grupoESO1D);

        Resultado resultadoLengua2AnaESO2A =
                new Resultado(lengua2, ana, grupoESO2A);

        Resultado resultadoLengua2AnaESO2B =
                new Resultado(lengua2, ana, grupoESO2B);

        Resultado resultadoLengua2AnaESO2C =
                new Resultado(lengua2, ana, grupoESO2C);

        Resultado resultadoLengua2AnaESO2D =
                new Resultado(lengua2, ana, grupoESO2D);

        Resultado resultadoLenguaBach1AnaBach1A =
                new Resultado(lenguaBach1, ana, grupoBach1A);

        Resultado resultadoLenguaBach1AnaBach1B =
                new Resultado(lenguaBach1, ana, grupoBach1B);

        Resultado resultadoLenguaBach2AnaBach2A =
                new Resultado(lenguaBach2, ana, grupoBach2A);

        Resultado resultadoLenguaBach2AnaBach2B =
                new Resultado(lenguaBach2, ana, grupoBach2B);


        Resultado resultadoMatematicas1LuisESO1A =
                new Resultado(matematicas1, luis, grupoESO1A);

        Resultado resultadoMatematicas1LuisESO1B =
                new Resultado(matematicas1, luis, grupoESO1B);

        Resultado resultadoMatematicas2LuisESO2A =
                new Resultado(matematicas2, luis, grupoESO2A);

        Resultado resultadoMatematicas2LuisESO2B =
                new Resultado(matematicas2, luis, grupoESO2B);

        Resultado resultadoMatematicas3LuisESO3A =
                new Resultado(matematicas3, luis, grupoESO3A);

        Resultado resultadoMatematicas3LuisESO3B =
                new Resultado(matematicas3, luis, grupoESO3B);

        Resultado resultadoMatematicas4LuisESO4A =
                new Resultado(matematicas4, luis, grupoESO4A);

        Resultado resultadoMatematicas4LuisESO4B =
                new Resultado(matematicas4, luis, grupoESO4B);

        Resultado resultadoMatematicasBach1LuisBach1A =
                new Resultado(matematicasBach1, luis, grupoBach1A);

        Resultado resultadoMatematicasBach1LuisBach1B =
                new Resultado(matematicasBach1, luis, grupoBach1B);

        Resultado resultadoMatematicasBach2LuisBach2A =
                new Resultado(matematicasBach2, luis, grupoBach2A);

        Resultado resultadoMatematicasBach2LuisBach2B =
                new Resultado(matematicasBach2, luis, grupoBach2B);


        Resultado resultadoHistoria1MartaESO1A =
                new Resultado(historia1, marta, grupoESO1A);

        Resultado resultadoHistoria1MartaESO1B =
                new Resultado(historia1, marta, grupoESO1B);

        Resultado resultadoHistoria2MartaESO2A =
                new Resultado(historia2, marta, grupoESO2A);

        Resultado resultadoHistoria2MartaESO2B =
                new Resultado(historia2, marta, grupoESO2B);

        Resultado resultadoHistoria3MartaESO3A =
                new Resultado(historia3, marta, grupoESO3A);

        Resultado resultadoHistoria3MartaESO3B =
                new Resultado(historia3, marta, grupoESO3B);

        Resultado resultadoHistoria4MartaESO4A =
                new Resultado(historia4, marta, grupoESO4A);

        Resultado resultadoHistoria4MartaESO4B =
                new Resultado(historia4, marta, grupoESO4B);

        Resultado resultadoHistoriaBach1MartaBach1A =
                new Resultado(historiaBach1, marta, grupoBach1A);

        Resultado resultadoHistoriaBach1MartaBach1B =
                new Resultado(historiaBach1, marta, grupoBach1B);

        Resultado resultadoHistoriaBach2MartaBach2A =
                new Resultado(historiaBach2, marta, grupoBach2A);

        Resultado resultadoHistoriaBach2MartaBach2B =
                new Resultado(historiaBach2, marta, grupoBach2B);


        Resultado resultadoFisica3CarlosESO3C =
                new Resultado(fisica3, carlos, grupoESO3C);

        Resultado resultadoFisica3CarlosESO3D =
                new Resultado(fisica3, carlos, grupoESO3D);

        Resultado resultadoFisica4CarlosESO4C =
                new Resultado(fisica4, carlos, grupoESO4C);

        Resultado resultadoFisica4CarlosESO4D =
                new Resultado(fisica4, carlos, grupoESO4D);

        Resultado resultadoFisicaBach1CarlosBach1C =
                new Resultado(fisicaBach1, carlos, grupoBach1C);

        Resultado resultadoFisicaBach1CarlosBach1D =
                new Resultado(fisicaBach1, carlos, grupoBach1D);

        Resultado resultadoFisicaBach2CarlosBach2C =
                new Resultado(fisicaBach2, carlos, grupoBach2C);

        Resultado resultadoFisicaBach2CarlosBach2D =
                new Resultado(fisicaBach2, carlos, grupoBach2D);


        Resultado resultadoIngles1LauraESO1A =
                new Resultado(ingles1, laura, grupoESO1A);

        Resultado resultadoIngles1LauraESO1B =
                new Resultado(ingles1, laura, grupoESO1B);

        Resultado resultadoIngles2LauraESO2A =
                new Resultado(ingles2, laura, grupoESO2A);

        Resultado resultadoIngles2LauraESO2B =
                new Resultado(ingles2, laura, grupoESO2B);

        Resultado resultadoIngles3LauraESO3A =
                new Resultado(ingles3, laura, grupoESO3A);

        Resultado resultadoIngles3LauraESO3B =
                new Resultado(ingles3, laura, grupoESO3B);

        Resultado resultadoIngles4LauraESO4A =
                new Resultado(ingles4, laura, grupoESO4A);

        Resultado resultadoIngles4LauraESO4B =
                new Resultado(ingles4, laura, grupoESO4B);

        Resultado resultadoInglesBach1LauraBach1A =
                new Resultado(inglesBach1, laura, grupoBach1A);

        Resultado resultadoInglesBach2LauraBach2A =
                new Resultado(inglesBach2, laura, grupoBach2A);


        Resultado resultadoBiologia3JavierESO3C =
                new Resultado(biologia3, javier, grupoESO3C);

        Resultado resultadoBiologia3JavierESO3D =
                new Resultado(biologia3, javier, grupoESO3D);

        Resultado resultadoBiologia4JavierESO4C =
                new Resultado(biologia4, javier, grupoESO4C);

        Resultado resultadoBiologia4JavierESO4D =
                new Resultado(biologia4, javier, grupoESO4D);

        Resultado resultadoBiologiaBach1JavierBach1C =
                new Resultado(biologiaBach1, javier, grupoBach1C);

        Resultado resultadoBiologiaBach1JavierBach1D =
                new Resultado(biologiaBach1, javier, grupoBach1D);


        Resultado resultadoBiologiaBach2JavierBach2C =
                new Resultado(biologiaBach2, javier, grupoBach2C);

        Resultado resultadoBiologiaBach2JavierBach2D =
                new Resultado(biologiaBach2, javier, grupoBach2D);


        resultadoRepository.saveAll(List.of(
                resultadoLengua1AnaESO1A,
                resultadoLengua1AnaESO1B,
                resultadoLengua1AnaESO1C,
                resultadoLengua1AnaESO1D,
                resultadoLengua2AnaESO2A,
                resultadoLengua2AnaESO2B,
                resultadoLengua2AnaESO2C,
                resultadoLengua2AnaESO2D,
                resultadoLenguaBach1AnaBach1A,
                resultadoLenguaBach1AnaBach1B,
                resultadoLenguaBach2AnaBach2A,
                resultadoLenguaBach2AnaBach2B,

                resultadoMatematicas1LuisESO1A,
                resultadoMatematicas1LuisESO1B,
                resultadoMatematicas2LuisESO2A,
                resultadoMatematicas2LuisESO2B,
                resultadoMatematicas3LuisESO3A,
                resultadoMatematicas3LuisESO3B,
                resultadoMatematicas4LuisESO4A,
                resultadoMatematicas4LuisESO4B,
                resultadoMatematicasBach1LuisBach1A,
                resultadoMatematicasBach1LuisBach1B,
                resultadoMatematicasBach2LuisBach2A,
                resultadoMatematicasBach2LuisBach2B,

                resultadoHistoria1MartaESO1A,
                resultadoHistoria1MartaESO1B,
                resultadoHistoria2MartaESO2A,
                resultadoHistoria2MartaESO2B,
                resultadoHistoria3MartaESO3A,
                resultadoHistoria3MartaESO3B,
                resultadoHistoria4MartaESO4A,
                resultadoHistoria4MartaESO4B,
                resultadoHistoriaBach1MartaBach1A,
                resultadoHistoriaBach1MartaBach1B,
                resultadoHistoriaBach2MartaBach2A,
                resultadoHistoriaBach2MartaBach2B,

                resultadoFisica3CarlosESO3C,
                resultadoFisica3CarlosESO3D,
                resultadoFisica4CarlosESO4C,
                resultadoFisica4CarlosESO4D,
                resultadoFisicaBach1CarlosBach1C,
                resultadoFisicaBach1CarlosBach1D,
                resultadoFisicaBach2CarlosBach2C,
                resultadoFisicaBach2CarlosBach2D,

                resultadoIngles1LauraESO1A,
                resultadoIngles1LauraESO1B,
                resultadoIngles2LauraESO2A,
                resultadoIngles2LauraESO2B,
                resultadoIngles3LauraESO3A,
                resultadoIngles3LauraESO3B,
                resultadoIngles4LauraESO4A,
                resultadoIngles4LauraESO4B,
                resultadoInglesBach1LauraBach1A,
                resultadoInglesBach2LauraBach2A,

                resultadoBiologia3JavierESO3C,
                resultadoBiologia3JavierESO3D,
                resultadoBiologia4JavierESO4C,
                resultadoBiologia4JavierESO4D,
                resultadoBiologiaBach1JavierBach1C,
                resultadoBiologiaBach1JavierBach1D,
                resultadoBiologiaBach2JavierBach2C,
                resultadoBiologiaBach2JavierBach2D
        ));*/
    }
}
