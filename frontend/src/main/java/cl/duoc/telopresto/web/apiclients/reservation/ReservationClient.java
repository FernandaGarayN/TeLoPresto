package cl.duoc.telopresto.web.apiclients.reservation;

import cl.duoc.telopresto.web.config.feign.FeignCarConfig;
import cl.duoc.telopresto.web.config.feign.FeignReservationConfig;
import cl.duoc.telopresto.web.services.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "reservation-client",
        url = "http://localhost:8091/api/reservations",
        configuration = FeignReservationConfig.class)
public interface ReservationClient {
    @GetMapping("/{username}")
    List<Reservation> findByUsername(@PathVariable("username") String username);
}
