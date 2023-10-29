package cl.duoc.telopresto.web.apiclients.user;


import cl.duoc.telopresto.web.config.feign.FeignReservationConfig;
import cl.duoc.telopresto.web.config.feign.FeignUserConfig;
import cl.duoc.telopresto.web.services.PasswordRecovery;
import cl.duoc.telopresto.web.services.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "user-client",
        url = "${spring.properties.feign.auth}",
        configuration = FeignUserConfig.class)
public interface UserClient {
    @PostMapping("/users/password-recovery")
    List<Reservation> passwordRecovery (@RequestBody PasswordRecovery passwordRecovery);
}
