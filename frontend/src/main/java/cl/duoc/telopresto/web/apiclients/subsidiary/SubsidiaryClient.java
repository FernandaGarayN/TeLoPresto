package cl.duoc.telopresto.web.apiclients.subsidiary;

import cl.duoc.telopresto.web.config.feign.FeignCarConfig;
import cl.duoc.telopresto.web.config.feign.FeignSubsidiaryConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "subsidiary-client",
        url = "http://localhost:8091/api/subsidiaries",
        configuration = FeignSubsidiaryConfig.class)
public interface SubsidiaryClient {
    @GetMapping("/names")
    List<String> listOfSubsidiary();
}
