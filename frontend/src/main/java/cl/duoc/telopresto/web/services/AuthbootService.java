package cl.duoc.telopresto.web.services;

import cl.duoc.telopresto.web.apiclients.authboot.AuthbootAuthRequest;
import cl.duoc.telopresto.web.apiclients.authboot.AuthbootAuthResponse;
import cl.duoc.telopresto.web.apiclients.authboot.AuthbootClient;
import feign.RetryableException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;

@RequiredArgsConstructor
public class AuthbootService {
  private final AuthbootClient loginApiClient;

  public AuthbootAuthResponse auth(AuthbootAuthRequest request) {
    try {
      return loginApiClient.auth(request);
    } catch (AuthenticationException e) {
      throw e;
    } catch (RetryableException e) {
      throw new AuthenticationServiceException("Servicio de autenticación no disponible", e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
