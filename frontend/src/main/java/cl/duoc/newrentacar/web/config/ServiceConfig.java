package cl.duoc.newrentacar.web.config;

import cl.duoc.newrentacar.web.apiclients.AuthbootClient;
import cl.duoc.newrentacar.web.services.AuthbootService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ServiceConfig {
  private final AuthbootClient authbootClient;
  @Bean
  public AuthbootService authbootService() {
    return new AuthbootService(authbootClient);
  }
}
