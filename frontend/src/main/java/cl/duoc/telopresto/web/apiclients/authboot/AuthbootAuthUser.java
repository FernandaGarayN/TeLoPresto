package cl.duoc.telopresto.web.apiclients.authboot;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthbootAuthUser {
    private String username;
    private String email;
    private List<String> authorities;
    private String token;
}
