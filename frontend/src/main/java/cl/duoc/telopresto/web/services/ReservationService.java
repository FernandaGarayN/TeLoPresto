package cl.duoc.telopresto.web.services;

import cl.duoc.telopresto.web.apiclients.reservation.ReservationClient;
import cl.duoc.telopresto.web.controller.reservation.ReservationForm;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReservationService {
    private final ReservationClient reservationClient;

    public List<Reservation> findByUsername(String username){
        List<Reservation> byUsername = reservationClient.findByUsername(username, null);
        byUsername.forEach(reservation -> {
            reservation.calculateTotal();
        });
        return byUsername;
    }

    public Reservation save(ReservationForm form, String username) {
        return reservationClient.save(Reservation.builder()
                .username(username)
                .car(Car.builder().id(form.getCarId()).build())
                .startAt(form.getStartAt())
                .endAt(form.getEndAt())
                .build());
    }

    public List<Reservation> findByUsernameAndPending(String username) {
        return reservationClient.findByUsername(username , "pending" );
    }
}
