package cl.duoc.newrentacar.api.service;

import cl.duoc.newrentacar.api.endpoint.model.Car;
import cl.duoc.newrentacar.api.repository.CarRepository;
import cl.duoc.newrentacar.api.repository.model.CarEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {
    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @Test
    void testGetAllCars() {
        CarEntity carEntity = new CarEntity();
        carEntity.setId(1);
        // Establece otros campos de carEntity si es necesario

        when(carRepository.findAll()).thenReturn(Collections.singletonList(carEntity));

        List<Car> cars = carService.getAllCars();

        assertFalse(cars.isEmpty());
        assertEquals(1, cars.size());
        assertEquals(1, cars.get(0).getId());

        verify(carRepository, times(1)).findAll();
    }

    @Test
    void testFindCarByIdFound() {
        CarEntity carEntity = new CarEntity();
        carEntity.setId(1);
        // Establece otros campos de carEntity si es necesario

        when(carRepository.findById(1)).thenReturn(Optional.of(carEntity));

        Car car = carService.findCarById(1);

        assertNotNull(car);
        assertEquals(1, car.getId());
        // Realiza más aserciones si es necesario

        verify(carRepository, times(1)).findById(1);
    }

    @Test
    void testFindCarByIdNotFound() {
        when(carRepository.findById(1)).thenReturn(Optional.empty());

        Car car = carService.findCarById(1);

        assertNull(car);
        verify(carRepository, times(1)).findById(1);
    }

    @Test
    void testDeleteCarByIdFound() {
        CarEntity carEntity = new CarEntity();
        carEntity.setId(1);
        // Establece otros campos de carEntity si es necesario

        when(carRepository.findById(1)).thenReturn(Optional.of(carEntity));

        Car deletedCar = carService.deleteCarById(1);

        assertNotNull(deletedCar);
        assertEquals(1, deletedCar.getId());
        // Realiza más aserciones si es necesario

        verify(carRepository, times(1)).findById(1);
        verify(carRepository, times(1)).delete(carEntity);
    }

    @Test
    void testDeleteCarByIdNotFound() {
        when(carRepository.findById(1)).thenReturn(Optional.empty());

        Car deletedCar = carService.deleteCarById(1);

        assertNull(deletedCar);
        verify(carRepository, times(1)).findById(1);
        verify(carRepository, times(0)).delete(any());
    }

    @Test
    void testAddCar() {
        Car car = new Car();
        car.setBrand("Brand");
        // Establece otros campos de Car si es necesario

        CarEntity carEntity = new CarEntity();
        carEntity.setBrand(car.getBrand());
        // Establece otros campos de carEntity si es necesario

        when(carRepository.save(any())).thenReturn(carEntity);

        boolean result = carService.addCar(car);

        assertTrue(result);
        verify(carRepository, times(1)).save(any());
    }

    @Test
    void testUpdateCarByIdFound() {
        Car carToUpdate = new Car();
        carToUpdate.setBrand("UpdatedBrand");
        // Establece otros campos de Car si es necesario

        CarEntity existingCarEntity = new CarEntity();
        existingCarEntity.setId(1);
        existingCarEntity.setBrand("ExistingBrand");
        // Establece otros campos de existingCarEntity si es necesario

        when(carRepository.findById(1)).thenReturn(Optional.of(existingCarEntity));
        when(carRepository.save(existingCarEntity)).thenReturn(existingCarEntity);

        Car updatedCar = carService.updateCarById(1, carToUpdate);

        assertNotNull(updatedCar);
        assertEquals("UpdatedBrand", updatedCar.getBrand());
        // Realiza más aserciones si es necesario

        verify(carRepository, times(1)).findById(1);
        verify(carRepository, times(1)).save(existingCarEntity);
    }

    @Test
    void testUpdateCarByIdNotFound() {
        Car carToUpdate = new Car();
        carToUpdate.setBrand("UpdatedBrand");
        // Establece otros campos de Car si es necesario

        when(carRepository.findById(1)).thenReturn(Optional.empty());

        Car updatedCar = carService.updateCarById(1, carToUpdate);

        assertNull(updatedCar);
        verify(carRepository, times(1)).findById(1);
        verify(carRepository, times(0)).save(any());
    }

}