package cl.duoc.telopresto.web.apiclients.payment;

import cl.duoc.telopresto.web.config.feign.FeignCarConfig;
import cl.duoc.telopresto.web.config.feign.FeignPaymentConfig;
import cl.duoc.telopresto.web.services.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "payment-client",
        url = "${spring.properties.feign.payment}",
        configuration = FeignPaymentConfig.class)
public interface PaymentClient {
    @GetMapping("/{username}")
    List<Payment> findByUsername(@PathVariable("username") String username);
}
