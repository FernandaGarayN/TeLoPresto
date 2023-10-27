package cl.duoc.telopresto.web.config.feign;

import cl.duoc.telopresto.web.apiclients.reservation.ReservationErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignReservationConfig {
  @Bean
  public ErrorDecoder feignReservationErrorDecoder() {
    return new ReservationErrorDecoder();
  }
}
