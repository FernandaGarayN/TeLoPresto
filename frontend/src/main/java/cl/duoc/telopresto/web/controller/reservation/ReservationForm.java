package cl.duoc.telopresto.web.controller.reservation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class ReservationForm {
    private Integer carId;
    private String car;
    private LocalDate startAt;
    private LocalDate endAt;
}
