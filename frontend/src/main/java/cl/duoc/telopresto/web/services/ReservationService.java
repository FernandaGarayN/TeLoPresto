package cl.duoc.telopresto.web.services;

import cl.duoc.telopresto.web.apiclients.reservation.ReservationClient;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReservationService {
    private final ReservationClient reservationClient;

    public List<Reservation> findByUsername(String username){
        return reservationClient.findByUsername(username);
    }
}
