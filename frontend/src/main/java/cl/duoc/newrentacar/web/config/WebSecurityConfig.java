package cl.duoc.newrentacar.web.config;

import cl.duoc.newrentacar.web.security.JwtAuthenticationProvider;
import cl.duoc.newrentacar.web.services.AuthbootService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final AuthbootService authbootService;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    var permitAll =
        new String[] {
          "/",
          "/index",
          "/error",
          "/servicios",
          "/busqueda-vehiculos",
          "/requisitos",
          "/rrss",
          "/vehiculos/**",
          "/contacto",
          "/css/**",
          "/js/**",
          "/img/**",
          "/webjars/**"
        };
    http.authorizeHttpRequests(
            requests ->
                requests.requestMatchers(permitAll).permitAll().anyRequest().authenticated())
        .formLogin(form -> form.loginPage("/login").permitAll())
        .logout(
            logout -> {
              logout.logoutUrl("/logout").permitAll();
              logout.logoutSuccessUrl("/");
            });
    return http.build();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    return new JwtAuthenticationProvider(authbootService);
  }

  @Bean
  public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
        .authenticationProvider(authenticationProvider())
        .build();
  }
}
