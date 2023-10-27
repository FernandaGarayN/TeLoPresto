package cl.duoc.telopresto.web.controller.reservation;

import cl.duoc.telopresto.web.services.Reservation;
import cl.duoc.telopresto.web.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    @GetMapping("/reservas")
    public String getReservations(ModelMap model, Authentication authentication){
       String username = (String)authentication.getPrincipal();
        List<Reservation> reservations = reservationService.findByUsername(username);
        model.addAttribute("results", reservations);
        return "reservas";
    }
}
