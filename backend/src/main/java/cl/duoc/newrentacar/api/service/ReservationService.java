package cl.duoc.newrentacar.api.service;

import cl.duoc.newrentacar.api.endpoint.model.Car;
import cl.duoc.newrentacar.api.endpoint.model.Reservation;
import cl.duoc.newrentacar.api.repository.CarRepository;
import cl.duoc.newrentacar.api.repository.ClientRepository;
import cl.duoc.newrentacar.api.repository.ReservationRepository;
import cl.duoc.newrentacar.api.repository.model.CarEntity;
import cl.duoc.newrentacar.api.repository.model.ClientEntity;
import cl.duoc.newrentacar.api.repository.model.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  ClientRepository clientRepository;

  @Autowired
  CarRepository carRepository;

  public List<Reservation> findByUserName(String userName, String status) {
    List<ReservationEntity> reservationsByUserName;
    if(status != null){
      reservationsByUserName = reservationRepository.findByClientUsernameAndStatus(userName, status);
    } else {
      reservationsByUserName = reservationRepository.findByClientUsername(userName);
    }

    List<Reservation> reservations = new ArrayList<>();
    for (ReservationEntity entity : reservationsByUserName) {
      reservations.add(getReservation(entity));
    }
    return reservations;
  }

  private static Reservation getReservation(ReservationEntity entity) {
    Reservation reservation = new Reservation();
    reservation.setId(entity.getId());
    reservation.setCar(getCar(entity.getCar()));
    reservation.setStartAt(entity.getStartAt());
    reservation.setEndAt(entity.getEndAt());
    return reservation;
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
    return car;
  }

  public Reservation save(Reservation reservation) {
    ClientEntity clientEntity = clientRepository.findByUsername(reservation.getUsername()).orElseThrow();
    CarEntity carEntity = carRepository.findById(reservation.getCar().getId()).orElseThrow();

    ReservationEntity reservationEntity = new ReservationEntity();

    reservationEntity.setClient(clientEntity);
    reservationEntity.setStartAt(reservation.getStartAt());
    reservationEntity.setEndAt(reservation.getEndAt());
    reservationEntity.setCar(carEntity);
    reservationEntity.setStatus("pending");

    reservationEntity = reservationRepository.save(reservationEntity);

    reservation.setId(reservationEntity.getId());
    return reservation;
  }
}
