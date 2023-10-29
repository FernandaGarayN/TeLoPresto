package cl.duoc.telopresto.web.config.feign;

import cl.duoc.telopresto.web.apiclients.user.UserErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignUserConfig {
  @Bean
  public ErrorDecoder feignUserErrorDecoder() {
    return new UserErrorDecoder();
  }
}
