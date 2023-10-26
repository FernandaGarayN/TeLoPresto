package cl.duoc.telopresto.web.config;

import cl.duoc.telopresto.web.apiclients.authboot.AuthbootClient;
import cl.duoc.telopresto.web.apiclients.car.CarClient;
import cl.duoc.telopresto.web.services.AuthbootService;
import cl.duoc.telopresto.web.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ServiceConfig {
  private final AuthbootClient authbootClient;
  private final CarClient carClient;

  @Bean
  public AuthbootService authbootService() {
    return new AuthbootService(authbootClient);
  }

  @Bean
  CarService carService() {
    return new CarService(carClient);
  }
}
