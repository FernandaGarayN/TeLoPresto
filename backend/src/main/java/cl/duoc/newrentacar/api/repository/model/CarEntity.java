package cl.duoc.newrentacar.api.repository.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 6)
    private String plateCode; //plate_code
    @Column(nullable = false, length = 30)
    private String brand;
    @Column(nullable = false, length = 30)
    private String model;
    @Column(nullable = false, length = 10)
    private String color;
    @Column(name = "factory_year", nullable = false, length = 4)
    private Integer year;
    @Column(nullable = false, length = 2)
    private Integer capacity;
    @Column(nullable = false, length = 6)
    private Integer dailyCost;
    @Column(nullable = false, length = 30)
    private String type;
    @Column(nullable = false, length = 50, name = "image")
    private String image;
    @Builder.Default
    @OneToMany(
            mappedBy = "car",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Set<ReservationEntity> reservations = new HashSet<>();

    @ManyToOne
    @JoinColumn(
            name = "subsidiary_id",
            updatable = false,
            nullable = false
    )
    private SubsidiaryEntity subsidiary;
}
