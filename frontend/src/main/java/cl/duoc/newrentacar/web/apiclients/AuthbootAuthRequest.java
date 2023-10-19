package cl.duoc.newrentacar.web.apiclients;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthbootAuthRequest {
    private String username;
    private String password;
}
