package cl.duoc.telopresto.web.services;

import cl.duoc.telopresto.web.apiclients.user.UserClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
    private final UserClient userClient;
    public void passwordRecovery(String email){
        userClient.passwordRecovery(PasswordRecovery.builder().email(email).build());
    }
}
