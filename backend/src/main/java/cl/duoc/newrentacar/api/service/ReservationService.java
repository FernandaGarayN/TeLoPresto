package cl.duoc.newrentacar.api.service;

import cl.duoc.newrentacar.api.endpoint.model.Car;
import cl.duoc.newrentacar.api.endpoint.model.Reservation;
import cl.duoc.newrentacar.api.repository.CarRepository;
import cl.duoc.newrentacar.api.repository.ReservationRepository;
import cl.duoc.newrentacar.api.repository.model.CarEntity;
import cl.duoc.newrentacar.api.repository.model.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> findByUserName(String userName){
        List<ReservationEntity> reservationsByUserName=reservationRepository.findByClientUsername(userName);
        List<Reservation> reservations= new ArrayList<>();
        for (ReservationEntity entity : reservationsByUserName) {
            reservations.add(getReservation(entity));
        }
    }

    private Reservation getReservation(ReservationEntity entity) {
        Reservation reservation=new Reservation();
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
        //car.setSubsidiary(String.valueOf(dbCar.getSubsidiary()));
        car.setColor(dbCar.getColor());
        car.setYear(dbCar.getYear());
        car.setCapacity(dbCar.getCapacity());
        car.setCost(dbCar.getDailyCost());
        car.setType(dbCar.getType());
        return car;
    }
}
