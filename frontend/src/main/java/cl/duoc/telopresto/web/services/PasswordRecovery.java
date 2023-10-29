package cl.duoc.telopresto.web.services;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PasswordRecovery {
    private String email;
}
