package cl.duoc.newrentacar.api.service;

import cl.duoc.newrentacar.api.endpoint.model.Car;
import cl.duoc.newrentacar.api.repository.CarRepository;
import cl.duoc.newrentacar.api.repository.model.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars(){
        List<Car> finalCars = new ArrayList<>();
        List<CarEntity> cars = (List<CarEntity>)carRepository.findAll();
        for(CarEntity entity: cars){
            Car car = new Car();
            car.setId(entity.getId());
            car.setPlateCode(entity.getPlateCode());
            car.setBrand(entity.getBrand());
            car.setModel(entity.getModel());
            car.setColor(entity.getColor());
            car.setYear(entity.getYear());
            car.setCapacity(entity.getCapacity());
            car.setCost(entity.getDailyCost());
            car.setType(entity.getType());
            finalCars.add(car);
        }
        return finalCars;
    }

    public Car findCarById(int id){
        Optional<CarEntity> foundCar = carRepository.findById(id);
        boolean isFound = foundCar.isPresent();
        if(isFound){
            CarEntity dbCar = foundCar.get();
            Car car = new Car();
            car.setId(dbCar.getId());
            car.setPlateCode(dbCar.getPlateCode());
            car.setBrand(dbCar.getBrand());
            car.setModel(dbCar.getModel());
            car.setColor(dbCar.getColor());
            car.setYear(dbCar.getYear());
            car.setCapacity(dbCar.getCapacity());
            car.setCost(dbCar.getDailyCost());
            car.setType(dbCar.getType());
            return car;
        }
        return null;
    }

    public Car deleteCarById(int id) {
        Optional<CarEntity> foundCar = carRepository.findById(id);
        boolean isFound = foundCar.isPresent();
        if(isFound){
            CarEntity dbCar = foundCar.get();
            Car car = new Car();
            car.setId(dbCar.getId());
            car.setPlateCode(dbCar.getPlateCode());
            car.setBrand(dbCar.getBrand());
            car.setModel(dbCar.getModel());
            car.setColor(dbCar.getColor());
            car.setYear(dbCar.getYear());
            car.setCapacity(dbCar.getCapacity());
            car.setCost(dbCar.getDailyCost());
            car.setType(dbCar.getType());
            carRepository.delete(dbCar);
            return car;
        }
        return null;
    }

    public boolean addCar(Car aCar) {
        CarEntity newCar = new CarEntity();
        newCar.setBrand(aCar.getBrand());
        newCar.setModel(aCar.getModel());
        newCar.setColor(aCar.getColor());
        newCar.setPlateCode(aCar.getPlateCode());
        newCar.setType(aCar.getType());
        newCar.setCapacity(aCar.getCapacity());
        newCar.setYear(aCar.getYear());
        newCar.setDailyCost(aCar.getCost());
        carRepository.save(newCar);
        return true;
    }

    public Car updateCarById(int id, Car aCar) {
        Optional<CarEntity> foundCar = carRepository.findById(id);
        boolean isFound = foundCar.isPresent();
        if(isFound){
            CarEntity car = foundCar.get();
            car.setBrand(aCar.getBrand());
            car.setColor(aCar.getColor());
            car.setModel(aCar.getModel());
            car.setPlateCode(aCar.getPlateCode());
            car.setYear(aCar.getYear());
            car.setCapacity(aCar.getCapacity());
            car.setDailyCost(aCar.getCost());
            car.setType(aCar.getType());
            carRepository.save(car);
            return aCar;
        }
        return null;
    }
}
