package cl.duoc.telopresto.web.config.feign;


import cl.duoc.telopresto.web.apiclients.subsidiary.SubsidiaryErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignSubsidiaryConfig {
  @Bean
  public ErrorDecoder feignSubsidiaryErrorDecoder() {
    return new SubsidiaryErrorDecoder();
  }
}
