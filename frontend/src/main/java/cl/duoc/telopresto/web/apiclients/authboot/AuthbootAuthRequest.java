package cl.duoc.telopresto.web.apiclients.authboot;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthbootAuthRequest {
    private String username;
    private String password;
}
