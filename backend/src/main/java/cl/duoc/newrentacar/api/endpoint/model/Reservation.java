package cl.duoc.newrentacar.api.endpoint.model;

import java.time.LocalDate;
import lombok.*;

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
