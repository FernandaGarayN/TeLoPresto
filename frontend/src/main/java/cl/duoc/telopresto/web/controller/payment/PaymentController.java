package cl.duoc.telopresto.web.controller.payment;

import cl.duoc.telopresto.web.services.PaymentService;
import cl.duoc.telopresto.web.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final ReservationService reservationService;

    @GetMapping("/pagos")
    public String getPayments(ModelMap model, Authentication authentication) {
        String username = (String) authentication.getPrincipal();
        model.addAttribute("results", paymentService.findByUsername(username));
        model.addAttribute("reservations", reservationService.findByUsernameAndPending(username));
        return "pagos";
    }
}
