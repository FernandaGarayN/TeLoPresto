package cl.duoc.telopresto.web.apiclients.car;

import cl.duoc.telopresto.web.config.feign.FeignCarConfig;
import cl.duoc.telopresto.web.services.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
    name = "car-client",
    url = "http://localhost:8091/api/cars/searching",
    configuration = FeignCarConfig.class)
public interface CarClient {
  @GetMapping
  List<Car> searchCars(
      @RequestParam(value = "brand", required = false) String brand,
      @RequestParam(value = "model", required = false) String model,
      @RequestParam(value = "color", required = false) String color,
      @RequestParam(value = "year", required = false) Integer year,
      @RequestParam(value = "subsidiary", required = false) String subsidiary,
      @RequestParam(value = "price", required = false) Integer price);
}
