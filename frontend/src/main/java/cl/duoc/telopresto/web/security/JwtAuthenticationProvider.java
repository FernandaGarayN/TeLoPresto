package cl.duoc.telopresto.web.security;

import cl.duoc.telopresto.web.apiclients.authboot.AuthbootAuthRequest;
import cl.duoc.telopresto.web.apiclients.authboot.AuthbootAuthUser;

import java.util.Collection;

import cl.duoc.telopresto.web.services.AuthbootService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {
  private final AuthbootService authbootService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    var username = authentication.getName();
    var password = authentication.getCredentials().toString();
    var request = AuthbootAuthRequest.builder().username(username).password(password).build();
    var response = authbootService.auth(request);
    var user = response.getData();
    return new UsernamePasswordAuthenticationToken(
        user.getUsername(), user.getToken(), generateAuthorities(user));
  }

  private Collection<? extends GrantedAuthority> generateAuthorities(AuthbootAuthUser user) {
    return user.getAuthorities().stream().map(SimpleGrantedAuthority::new).toList();
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
