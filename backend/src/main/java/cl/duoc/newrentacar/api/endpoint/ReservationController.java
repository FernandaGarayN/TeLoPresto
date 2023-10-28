package cl.duoc.newrentacar.api.endpoint;

import cl.duoc.newrentacar.api.endpoint.model.Reservation;
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
  public ResponseEntity<List<Reservation>> getByUsername(@PathVariable("username") String username
    , @RequestParam(value = "status", required = false) String status) {
    return ResponseEntity.ok(reservationService.findByUserName(username, status));
  }

  @PostMapping("/reservations")
  public ResponseEntity<Reservation> save(@RequestBody Reservation reservation) {
    return ResponseEntity.ok(reservationService.save(reservation));
  }

}

