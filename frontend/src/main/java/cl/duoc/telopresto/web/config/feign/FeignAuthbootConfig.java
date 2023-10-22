package cl.duoc.telopresto.web.config.feign;

import cl.duoc.telopresto.web.apiclients.authboot.AuthbootErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignAuthbootConfig {
  @Bean
  public ErrorDecoder feignErrorDecoder() {
    return new AuthbootErrorDecoder();
  }
}
