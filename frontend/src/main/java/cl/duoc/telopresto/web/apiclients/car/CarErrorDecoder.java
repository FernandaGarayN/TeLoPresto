package cl.duoc.telopresto.web.apiclients.car;

import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;

@Slf4j
public class CarErrorDecoder implements ErrorDecoder {
  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String methodKey, feign.Response response) {
    log.error(String.format("Error to call method [%s]: [Status=%d] | [Body=%s]", methodKey, response.status(), response.body()));
    return switch (response.status()) {
      case 400 -> new AuthenticationServiceException("Error al autenticar.");
      case 401 -> new BadCredentialsException("Usuario o contraseña inválidos.");
      case 403 -> new AccountExpiredException("La cuenta está expirada.");
      default -> defaultErrorDecoder.decode(methodKey, response);
    };
  }
}
