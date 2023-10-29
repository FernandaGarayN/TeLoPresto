package cl.duoc.telopresto.web.controller.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PasswordRecoveryForm {
    private String email;
}
