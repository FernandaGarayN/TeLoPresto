package cl.duoc.newrentacar.api.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 1000, name = "description")
    private String description;

    @Column(nullable = false, name = "rate")
    private Integer rate;

    @ManyToOne
    @JoinColumn(
            name = "reservation_id",
            updatable = false,
            nullable = false
    )
    private ReservationEntity reservation;

}
