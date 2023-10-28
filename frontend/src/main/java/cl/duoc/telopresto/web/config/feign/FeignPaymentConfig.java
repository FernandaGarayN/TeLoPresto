package cl.duoc.telopresto.web.config.feign;

import cl.duoc.telopresto.web.apiclients.authboot.AuthbootErrorDecoder;
import cl.duoc.telopresto.web.apiclients.payment.PaymentErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignPaymentConfig {
  @Bean
  public ErrorDecoder feignPaymentErrorDecoder() {
    return new PaymentErrorDecoder();
  }

}
