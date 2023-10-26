package cl.duoc.newrentacar.api.repository.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
}
