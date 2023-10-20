package cl.duoc.newrentacar.web.config.feign;

import cl.duoc.newrentacar.web.apiclients.AuthbootErrorDecoder;
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
