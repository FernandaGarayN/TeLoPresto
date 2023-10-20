package cl.duoc.newrentacar.web.services;

import cl.duoc.newrentacar.web.apiclients.AuthbootAuthRequest;
import cl.duoc.newrentacar.web.apiclients.AuthbootAuthResponse;
import cl.duoc.newrentacar.web.apiclients.AuthbootClient;
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
