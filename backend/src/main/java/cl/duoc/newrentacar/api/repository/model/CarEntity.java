package cl.duoc.newrentacar.api.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
