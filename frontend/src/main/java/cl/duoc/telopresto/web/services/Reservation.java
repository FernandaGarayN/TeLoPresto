package cl.duoc.telopresto.web.services;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private Integer id;
    private String username;
    private Car car;
    private LocalDate startAt;
    private LocalDate endAt;
    private long days;
    private long amount;

    public void calculateTotal() {
        if (startAt != null && endAt != null) {
            days = endAt.toEpochDay() - startAt.toEpochDay();
            amount = car.getCost() * days;
        }
    }
}
