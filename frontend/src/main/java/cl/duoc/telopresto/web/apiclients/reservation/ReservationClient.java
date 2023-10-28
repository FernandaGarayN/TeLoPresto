package cl.duoc.telopresto.web.apiclients.reservation;

import cl.duoc.telopresto.web.config.feign.FeignCarConfig;
import cl.duoc.telopresto.web.config.feign.FeignReservationConfig;
import cl.duoc.telopresto.web.services.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(
        name = "reservation-client",
        url = "${spring.properties.feign.reservations}",
        configuration = FeignReservationConfig.class)
public interface ReservationClient {
    @GetMapping("/{username}")
    List<Reservation> findByUsername(@PathVariable("username") String username);

    @PostMapping
    void save(Reservation reservation);
}
