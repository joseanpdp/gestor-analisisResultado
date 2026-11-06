package japdp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Inicializador de servlet utilizado para desplegar la aplicación
 * en un servidor externo, como Tomcat.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Configura la aplicación Spring Boot.
     *
     * @param application Constructor de la aplicación
     * @return Aplicación configurada
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GestorFormulariosApplication.class);
    }
}