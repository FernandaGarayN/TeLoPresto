package cl.duoc.newrentacar.api.endpoint;

import cl.duoc.newrentacar.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
}
