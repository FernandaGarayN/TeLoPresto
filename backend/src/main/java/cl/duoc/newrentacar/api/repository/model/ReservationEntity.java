package cl.duoc.newrentacar.api.repository.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "start_at")
    private LocalDate startAt;

    @Column(nullable = false, name = "end_at")
    private LocalDate endAt;

    @Column(nullable = false, length = 30, name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(
            name = "car_id",
            updatable = false,
            nullable = false
    )
    private CarEntity car;

    @ManyToOne
    @JoinColumn(
            name = "client_id",
            updatable = false,
            nullable = false
    )
    private ClientEntity client;

    @Builder.Default
    @OneToMany(
            mappedBy = "reservation",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Set<CommentEntity> comments = new HashSet<>();

    @Builder.Default
    @OneToMany(
            mappedBy = "reservation",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Set<PaymentEntity> payments = new HashSet<>();
}
