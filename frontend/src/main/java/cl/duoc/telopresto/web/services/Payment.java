package cl.duoc.telopresto.web.services;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Payment {
    private Integer id;
    private Integer reservationId;
    private String type;
    private Integer amount;
    private LocalDate paymentDate;
}
