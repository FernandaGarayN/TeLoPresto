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
}
