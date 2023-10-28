package cl.duoc.telopresto.web.controller.reservation;

import cl.duoc.telopresto.web.services.Car;
import cl.duoc.telopresto.web.services.CarService;
import cl.duoc.telopresto.web.services.Reservation;
import cl.duoc.telopresto.web.services.ReservationService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ReservationController {
  private final ReservationService reservationService;
  private final CarService carService;

  @GetMapping("/mis-reservas")
  public String getReservations(
      ModelMap model,
      @RequestParam(value = "highlight", required = false) Integer highlight,
      Authentication authentication) {
    String username = (String) authentication.getPrincipal();
    List<Reservation> reservations = reservationService.findByUsername(username);
    model.addAttribute("results", reservations);
    model.addAttribute("highlight", highlight);
    return "mis-reservas";
  }

  @GetMapping("/reservas-clientes")
  public String getReservationsClient(ModelMap model) {
    model.addAttribute("reservationSearchForm", ReservationSearchForm.builder().build());
    return "reservas-clientes";
  }

  @PostMapping("/reservas-clientes")
  public String postReservationsClient(
      ModelMap model,
      @Valid @ModelAttribute ReservationSearchForm form,
      BindingResult bindingResult) {
    Integer rut = form.getRut();
    model.addAttribute("reservationSearchForm", form);
    return "reservas-clientes";
  }

  @GetMapping("/nueva-reserva")
  public String getNewReservation(ModelMap model, @RequestParam("idVehiculo") Integer id) {
    Car car = carService.findById(id);
    ReservationForm reservationForm =
        ReservationForm.builder()
            .carId(car.getId())
            .car(car.getBrand().concat(" - ").concat(car.getModel()))
            .build();
    model.addAttribute("reservationForm", reservationForm);
    return "nueva-reserva";
  }

  @PostMapping("/nueva-reserva")
  public String postNewReservation(
      ModelMap model,
      @Valid @ModelAttribute("reservationForm") ReservationForm form,
      BindingResult bindingResult,
      Authentication authentication) {
    String username = (String) authentication.getPrincipal();
    model.addAttribute("reservationForm", form);
    if (bindingResult.hasErrors()) {
      return "nueva-reserva";
    }
    Reservation reservation = reservationService.save(form, username);
    return String.format("redirect:/mis-reservas?highlight=%d", reservation.getId());
  }
}
