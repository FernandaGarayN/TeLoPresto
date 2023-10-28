package cl.duoc.newrentacar.api.endpoint.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Integer id;
    private Integer reservationId;
    private String type;
    private Integer amount;
    private LocalDate paymentDate;
}
