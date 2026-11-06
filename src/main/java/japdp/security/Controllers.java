package japdp.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

/**
 * Controlador encargado de gestionar las vistas relacionadas con la
 * autenticación de usuarios.
 *
 * Proporciona los puntos de acceso para mostrar las páginas de inicio
 * y cierre de sesión.
 */
@Controller
public class Controllers {

  /**
   * Muestra la página de inicio de sesión.
   *
   * @return Nombre de la vista correspondiente al formulario de inicio de sesión
   */
  @GetMapping("/login")
  public String login() {
    return "security/login";
  }

  /**
   * Muestra la página de cierre de sesión.
   *
   * Añade al modelo el nombre del usuario autenticado para que pueda
   * mostrarse en la vista.
   *
   * @param model Modelo utilizado para enviar atributos a la vista
   * @param principal Usuario autenticado
   * @return Nombre de la vista correspondiente al cierre de sesión
   */
  @GetMapping("/logout")
  public String logout(Model model, Principal principal, RedirectAttributes redirectAttributes) {
    model.addAttribute("name", principal.getName());
    redirectAttributes.addFlashAttribute("tipo", "exito");
    redirectAttributes.addFlashAttribute("mensaje", "Se ha cerrado sesión con éxito");
    return "security/logout";
  }

}