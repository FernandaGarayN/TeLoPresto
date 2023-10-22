package cl.duoc.telopresto.web.config;

import cl.duoc.telopresto.web.apiclients.authboot.AuthbootClient;
import cl.duoc.telopresto.web.services.AuthbootService;
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
