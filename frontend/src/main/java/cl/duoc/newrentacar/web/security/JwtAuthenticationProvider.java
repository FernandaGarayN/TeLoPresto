package cl.duoc.newrentacar.web.security;

import cl.duoc.newrentacar.web.apiclients.AuthbootAuthRequest;
import cl.duoc.newrentacar.web.services.AuthbootService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {
  private final AuthbootService authbootService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    var username = authentication.getName();
    var password = authentication.getCredentials().toString();
    var request = AuthbootAuthRequest.builder().username(username).password(password).build();
    var login = authbootService.auth(request);
    return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
