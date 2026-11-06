package japdp.controller.thymeleaf;

import japdp.model.*;
import japdp.model.dto.request.PasswordDTO;
import japdp.service.DocenteService;
import japdp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
import java.util.*;

/**
 * Controlador que gestiona la selección de asignaturas y grupos.
 * También permite cambiar la contraseña del usuario autenticado.
 */
@Controller
@RequestMapping("/")
public class SeleccionController {

    /**
     * Servicio encargado de la lógica de negocio de los docentes.
     */
    private final DocenteService docenteService;

    /**
     * Servicio encargado de la lógica de negocio de los usuarios.
     */
    private final UsuarioService usuarioService;

    /**
     * Codificador utilizado para cifrar y comprobar contraseñas.
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Indica si la aplicación se ejecuta como demostración.
     */
    @Value("${app.isDemo}")
    private boolean isDemo;

    /**
     * Constructor del controlador.
     *
     * @param docenteService Servicio de docentes
     * @param usuarioService Servicio de usuarios
     * @param passwordEncoder Codificador de contraseñas
     */
    public SeleccionController(DocenteService docenteService, UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.docenteService = docenteService;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Muestra la vista de selección de asignatura y grupo.
     *
     * Obtiene el usuario autenticado, comprueba que tenga un docente asociado
     * y organiza los resultados por asignatura y grupo.
     *
     * @param model Modelo para enviar datos a la vista
     * @return Nombre de la plantilla Thymeleaf
     */
    @GetMapping
    public String irSeleccionUnidad(/*@RequestParam("docenteId") Long docenteId, */Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<Usuario> optional = usuarioService.findByUsername(username);
        if (!optional.isEmpty()) {
            Usuario usuario = optional.get();
            Docente docente = usuario.getDocente();
            if (docente != null) {
                List<Resultado> resultados = docente.getResultados();
                Map<String, List<Grupo>> gruposMap = new LinkedHashMap<>();
                Map<String, List<Resultado>> resultadosMap = new LinkedHashMap<>();
                for (Resultado resultado : resultados) {
                    Asignatura asignatura = resultado.getAsignatura();
                    Grupo grupo = resultado.getGrupo();
                    String asignaturaNombreNivel = asignatura.getNombre() + " - " + asignatura.getNivel();
                    if (!gruposMap.keySet().contains(asignaturaNombreNivel)) {
                        List<Grupo> grupos = new ArrayList<>();
                        grupos.add(grupo);
                        gruposMap.put(asignaturaNombreNivel, grupos);
                    } else {
                        gruposMap.get(asignaturaNombreNivel).add(grupo);
                    }
                    if (!resultadosMap.keySet().contains(asignaturaNombreNivel)) {
                        List<Resultado> resultadosList = new ArrayList<>();
                        resultadosList.add(resultado);
                        resultadosMap.put(asignaturaNombreNivel, resultadosList);
                    } else {
                        resultadosMap.get(asignaturaNombreNivel).add(resultado);
                    }
                }
                model.addAttribute("docente", docente);
                model.addAttribute("resultadosMap", resultadosMap);
                model.addAttribute("gruposMap", gruposMap);
                return "seleccionAsignaturaGrupo";
            }
            model.addAttribute("mensaje", "Docente no encontrado");
            return "login";
        }
        model.addAttribute("mensaje", "Usuario no encontrado");
        return "login";
    }

    /**
     * Muestra el formulario para cambiar la contraseña de un docente.
     *
     * @param model Modelo para enviar datos a la vista
     * @return Nombre de la plantilla Thymeleaf
     */
    @GetMapping("/changePassword")
    public String showChangePassword(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        //Usuario usuario = usuarioService.findByUsername(username).get();
        PasswordDTO usuarioDTO = new PasswordDTO();
        usuarioDTO.setUsername(username);
        model.addAttribute("usuario", usuarioDTO);
        model.addAttribute("isDemo", isDemo);
        //model.addAttribute("docenteLoggeado", docente);
        return "cambiarPassword";
    }

    /**
     * Procesa el cambio de contraseña de un docente.
     *
     * Comprueba que exista el docente, valida la contraseña actual,
     * verifica que la nueva contraseña coincida con su confirmación y,
     * si todo es correcto, guarda la contraseña codificada.
     *
     * @param chanPassDocenteDTO Datos recibidos desde el formulario
     * @param redirectAttributes Atributos temporales para redirección
     * @return Redirección a la vista correspondiente
     */
    @PostMapping("/changePassword")
    public String cahngePassword(@ModelAttribute("docente") PasswordDTO chanPassDocenteDTO,
                                 RedirectAttributes redirectAttributes) {

        Optional<Usuario> optional = usuarioService.findByUsername(chanPassDocenteDTO.getUsername());
        if (optional.isPresent()) {
            Usuario usuario = optional.get();
            if (passwordEncoder.matches(chanPassDocenteDTO.getPasswordActual(), usuario.getPassword())) {
                if (chanPassDocenteDTO.getPassword().equals(chanPassDocenteDTO.getConfirmacion())) {
                    usuario.setPassword(passwordEncoder.encode(chanPassDocenteDTO.getPassword()));
                    usuarioService.save(usuario);
                    redirectAttributes.addFlashAttribute("mensaje", "Contraseña cambiada correctamente");
                    redirectAttributes.addFlashAttribute("tipo", "exito");
                    return "redirect:/";
                } else {
                    redirectAttributes.addFlashAttribute("mensaje", "La contraseña y su confirmación no coinciden");
                    redirectAttributes.addFlashAttribute("tipo", "error");
                    return "redirect:/changePassword/" + chanPassDocenteDTO.getUsername();
                }
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "Contraseña actual incorrecta");
                redirectAttributes.addFlashAttribute("tipo", "error");
                return "redirect:/changePassword/" + chanPassDocenteDTO.getUsername();
            }
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "El usuario no existe");
            redirectAttributes.addFlashAttribute("tipo", "error");
            return "redirect:/changePassword/" + chanPassDocenteDTO.getUsername();
        }
    }
}