package cl.duoc.newrentacar.api.endpoint;

import cl.duoc.newrentacar.api.endpoint.model.Reservation;
import cl.duoc.newrentacar.api.repository.model.PaymentEntity;
import cl.duoc.newrentacar.api.service.PaymentService;
import cl.duoc.newrentacar.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/reservations/{username}")
    public ResponseEntity<List<Reservation>> getByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(reservationService.findByUserName(username));
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.save(reservation));
    }

}

