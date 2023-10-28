package cl.duoc.telopresto.web.apiclients.authboot;

import cl.duoc.telopresto.web.config.feign.FeignAuthbootConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "authboot-client",
    url = "${spring.properties.feign.auth}",
    configuration = FeignAuthbootConfig.class)
public interface AuthbootClient {

  @PostMapping("/auth")
  AuthbootAuthResponse auth(@RequestBody AuthbootAuthRequest loginApi);
}
