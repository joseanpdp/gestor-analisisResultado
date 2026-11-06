package japdp.security;

import japdp.model.Usuario;
import japdp.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Configuración de seguridad de la aplicación.
 *
 * Define las reglas de autorización, el mecanismo de autenticación,
 * la configuración de CORS, la gestión del cierre de sesión y los
 * componentes necesarios para la autenticación de usuarios y el
 * cifrado de contraseñas.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configura la cadena de filtros de seguridad de Spring Security.
     *
     * Establece la configuración de CORS, deshabilita la protección CSRF,
     * define las rutas públicas y protegidas, configura el formulario
     * de inicio de sesión y el cierre de sesión.
     *
     * @param httpSecurity Objeto utilizado para configurar la seguridad HTTP
     * @return Cadena de filtros de seguridad configurada
     * @throws Exception Si ocurre un error durante la configuración
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors(cors -> {
                    CorsConfigurationSource source = request -> {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(List.of("*"));
                        config.setAllowedMethods(List.of("*"));
                        config.setAllowedHeaders(List.of("*"));
                        return config;
                    };
                    cors.configurationSource(source);
                })
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers("/css", "/css/**").permitAll()
                                .requestMatchers("/").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/api", "/api/**").permitAll()/*.hasAnyRole("ADMIN", "USER")*/
                                .requestMatchers("/h2-console", "/h2-console/**").hasRole("ADMIN")
                                .requestMatchers("/analisis", "/analisis/**").hasAnyRole("ADMIN", "USER")
                                .anyRequest().authenticated()
                );

        httpSecurity.formLogin(
                configurer -> configurer
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?try_again")
                        .permitAll()
        );

        httpSecurity.logout(
                configurer -> configurer
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
        );

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UsuarioService usuarioService) {
        return username -> {
            Optional<Usuario> optional = usuarioService.findByUsername(username);
            if (!optional.isEmpty()) {
                return new SecurityUsuario(optional.get());
            } else {
                throw new UsernameNotFoundException("No se ha encontrado al usuario.");
            }
        };
    }

    /**
     * Crea el codificador de contraseñas utilizado por la aplicación.
     *
     * Configura un {@code DelegatingPasswordEncoder} con BCrypt como
     * algoritmo principal y mantiene compatibilidad con contraseñas
     * almacenadas sin cifrar mediante el codificador {@code noop}.
     *
     * @return Codificador de contraseñas configurado
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("bcrypt", new BCryptPasswordEncoder());

        DelegatingPasswordEncoder encoder =
                new DelegatingPasswordEncoder("bcrypt", encoders);
        encoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());

        return encoder;
    }
}