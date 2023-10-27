package cl.duoc.newrentacar.api.endpoint.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Reservation {
    private Integer id;
    private Car car;
    private LocalDate startAt;
    private LocalDate endAt;
}
