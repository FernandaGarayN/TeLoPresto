package cl.duoc.newrentacar.web.apiclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authboot-client", url = "http://localhost:8090/api")
public interface AuthbootClient {

    @PostMapping("/auth")
    AuthbootAuthResponse auth(@RequestBody AuthbootAuthRequest loginApi);
}
