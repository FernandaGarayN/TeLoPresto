package cl.duoc.newrentacar.api.endpoint;

import cl.duoc.newrentacar.api.endpoint.model.Car;
import cl.duoc.newrentacar.api.service.CarService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
  @Autowired
  private CarService carService;

  @GetMapping("/cars")
  public ResponseEntity<GetCarsResponse> get() {
    GetCarsResponse response = new GetCarsResponse();
    response.setCars(carService.getAllCars());
    return ResponseEntity.ok(response);
  }

  @GetMapping("/cars/years")
  public ResponseEntity<List<Integer>> getYears() {
    List<Car> cars = carService.getAllCars();
    List<Integer> years = new ArrayList<>();
    for (Car car : cars) {
      if (!years.contains(car.getYear())) {
        years.add(car.getYear());
      }
    }
    return ResponseEntity.ok(years);
  }

  @GetMapping("/cars/searching")
  public ResponseEntity<List<Car>> searching(
    @RequestParam(value = "brand", required = false) String brand,
    @RequestParam(value = "model", required = false) String model,
    @RequestParam(value = "color", required = false) String color,
    @RequestParam(value = "year", required = false) Integer year,
    @RequestParam(value = "subsidiary", required = false) String subsidiary,
    @RequestParam(value = "price", required = false) Integer price
  ) {
    return ResponseEntity.ok(carService.search(brand, model, color, year, subsidiary, price));
  }

  @GetMapping("/cars/brands")
  public ResponseEntity<List<String>> getBrands() {
    List<Car> cars = carService.getAllCars();
    List<String> brands = new ArrayList<>();
    for (Car car : cars) {
      if (!brands.contains(car.getBrand())) {
        brands.add(car.getBrand());
      }
    }
    return ResponseEntity.ok(brands);
  }

  @GetMapping("/cars/{id}")
  public ResponseEntity<GetCarResponse> get(@PathVariable int id) {
    Car foundCar = carService.findCarById(id);

    if (foundCar != null) {
      GetCarResponse response = new GetCarResponse();
      response.setCar(foundCar);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/cars/{id}")
  public ResponseEntity<GetCarResponse> delete(@PathVariable int id) {
    Car deletedCar = carService.deleteCarById(id);
    if (deletedCar != null) {
      GetCarResponse response = new GetCarResponse();
      response.setCar(deletedCar);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/cars")
  public ResponseEntity<GetCarResponse> post(@RequestBody Car aCar) {
    boolean added = carService.addCar(aCar);
    if (added) {
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping("/cars/{id}")
  public ResponseEntity<GetCarResponse> put(@PathVariable("id") int id, @RequestBody Car aCar) {
    Car updated = carService.updateCarById(id, aCar);
    if (updated != null) {
      GetCarResponse response = new GetCarResponse();
      response.setCar(updated);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
