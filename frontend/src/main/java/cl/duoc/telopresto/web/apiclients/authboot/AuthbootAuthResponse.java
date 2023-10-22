package cl.duoc.telopresto.web.apiclients.authboot;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthbootAuthResponse {
  private LocalDateTime date;
  private Map<String, String> success;
  private AuthbootAuthUser data;
}
