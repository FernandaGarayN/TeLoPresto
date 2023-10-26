package cl.duoc.telopresto.web.services;

import cl.duoc.telopresto.web.apiclients.car.CarClient;
import cl.duoc.telopresto.web.controller.car.CarSearchForm;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CarService {
  private final CarClient carClient;

  public List<Car> searchCars(CarSearchForm carSearchForm) {
    List<Car> cars = carClient.searchCars(
            carSearchForm.getBrand(),
            carSearchForm.getModel(),
            carSearchForm.getColor(),
            carSearchForm.getYear(),
            carSearchForm.getSubsidiary(),
            carSearchForm.getPrice());
    return cars;
  }
}
