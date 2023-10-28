package cl.duoc.newrentacar.api.service;

import cl.duoc.newrentacar.api.endpoint.model.Car;
import cl.duoc.newrentacar.api.endpoint.model.CarComment;
import cl.duoc.newrentacar.api.repository.CarRepository;
import cl.duoc.newrentacar.api.repository.model.CarEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
  @Autowired
  private CarRepository carRepository;

  public List<Car> getAllCars() {
    List<Car> finalCars = new ArrayList<>();
    List<CarEntity> cars = (List<CarEntity>) carRepository.findAll();
    for (CarEntity entity : cars) {
      finalCars.add(getCar(entity));
    }
    return finalCars;
  }

  public Car findCarById(int id) {
    Optional<CarEntity> foundCar = carRepository.findById(id);
    boolean isFound = foundCar.isPresent();
    if (isFound) {
      CarEntity dbCar = foundCar.get();
      return getCar(dbCar);
    }
    return null;
  }

  public Car deleteCarById(int id) {
    Optional<CarEntity> foundCar = carRepository.findById(id);
    boolean isFound = foundCar.isPresent();
    if (isFound) {
      CarEntity dbCar = foundCar.get();
      carRepository.delete(dbCar);
      return getCar(dbCar);
    }
    return null;
  }

  private static Car getCar(CarEntity dbCar) {
    Car car = new Car();
    car.setId(dbCar.getId());
    car.setPlateCode(dbCar.getPlateCode());
    car.setBrand(dbCar.getBrand());
    car.setModel(dbCar.getModel());
    car.setSubsidiary(dbCar.getSubsidiary().getName());
    car.setColor(dbCar.getColor());
    car.setYear(dbCar.getYear());
    car.setCapacity(dbCar.getCapacity());
    car.setCost(dbCar.getDailyCost());
    car.setType(dbCar.getType());
    car.setImage(dbCar.getImage());

    List<CarComment> comments = new ArrayList<>();

    dbCar.getReservations().forEach(reservations ->
      reservations.getComments().forEach(commentEntity ->
        comments.add(
          new CarComment(
            commentEntity.getId(),
            commentEntity.getDescription(),
            commentEntity.getRate()
          )
        )
      )
    );

    car.setComments(comments);

    return car;
  }

  public boolean addCar(Car aCar) {
    carRepository.save(getCarEntity(aCar));
    return true;
  }

  private static CarEntity getCarEntity(Car aCar) {
    CarEntity newCar = new CarEntity();
    newCar.setBrand(aCar.getBrand());
    newCar.setModel(aCar.getModel());
    //newCar.setSubsidiary(aCar.getSubsidiary());
    newCar.setColor(aCar.getColor());
    newCar.setPlateCode(aCar.getPlateCode());
    newCar.setType(aCar.getType());
    newCar.setCapacity(aCar.getCapacity());
    newCar.setYear(aCar.getYear());
    newCar.setDailyCost(aCar.getCost());
    return newCar;
  }

  public Car updateCarById(int id, Car aCar) {
    Optional<CarEntity> foundCar = carRepository.findById(id);
    boolean isFound = foundCar.isPresent();
    if (isFound) {
      carRepository.save(getCarEntity(aCar));
      return aCar;
    }
    return null;
  }

  public List<Car> search(
    String brand, String model, String color, Integer year, String subsidiary, Integer price) {
    List<CarEntity> found = carRepository.findCars(brand, model, color, year, subsidiary, price);
    List<Car> finalCars = new ArrayList<>();
    for (CarEntity entity : found) {
      finalCars.add(getCar(entity));
    }
    return finalCars;
  }
}
