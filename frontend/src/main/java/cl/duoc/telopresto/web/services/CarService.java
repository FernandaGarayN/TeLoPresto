package cl.duoc.telopresto.web.services;

import cl.duoc.telopresto.web.apiclients.car.CarClient;
import cl.duoc.telopresto.web.controller.car.CarSearchForm;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarService {
  private final CarClient carClient;


 public List<Integer> getListOfYears(){
   return null;
 }
  public List<Car> searchCars(CarSearchForm carSearchForm) {
    return carClient.searchCars(
        carSearchForm.getBrand(),
        carSearchForm.getModel(),
        carSearchForm.getColor(),
        carSearchForm.getYear(),
        carSearchForm.getSubsidiary(),
        carSearchForm.getPrice());
  }

  public Car findById(Integer id){
    return carClient.findById(id).getCar();
  }
}
