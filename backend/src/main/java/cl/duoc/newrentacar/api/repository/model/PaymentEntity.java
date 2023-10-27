package cl.duoc.newrentacar.api.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "reservation_id",
            updatable = false,
            nullable = false
    )
    private ReservationEntity reservation;

    @Column(nullable = false, length = 25, name = "type")
    private String type;

    @Column(nullable = false, name = "amount")
    private Integer amount;

    @Column(nullable = false,name = "payment_date")
    private LocalDate paymentDate;

}
