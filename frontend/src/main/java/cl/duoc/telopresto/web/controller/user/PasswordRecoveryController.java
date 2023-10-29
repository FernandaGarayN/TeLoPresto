package cl.duoc.telopresto.web.controller.user;

import cl.duoc.telopresto.web.controller.reservation.ReservationSearchForm;
import cl.duoc.telopresto.web.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PasswordRecoveryController {
    private final UserService userService;

    @GetMapping("/recuperar-contrasenia")
    public String getPasswordRecovery(ModelMap model) {
        model.addAttribute("passwordRecoveryForm", PasswordRecoveryForm.builder().build());
        return "recuperar-contrasenia";
    }
    @PostMapping("/recuperar-contrasenia")
    public String postPasswordRecovery(
            ModelMap model,
            @Valid @ModelAttribute PasswordRecoveryForm form,
            BindingResult bindingResult) {
        String email = form.getEmail();
        userService.passwordRecovery(email);
        model.addAttribute("passwordRecoveryForm", form);
        return "recuperar-contrasenia";
    }
}
