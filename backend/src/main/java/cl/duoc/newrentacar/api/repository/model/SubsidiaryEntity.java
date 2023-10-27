package cl.duoc.newrentacar.api.repository.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subsidiary")
@Getter
@Setter
public class SubsidiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50, name = "name")
    private String name;

    @Column(nullable = false, length = 200, name = "address")
    private String address;

    @Column(nullable = false, name = "phone_number")
    private Integer phoneNumber;

    @Builder.Default
    @OneToMany(
            mappedBy = "subsidiary",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Set<CarEntity> cars = new HashSet<>();

    @Builder.Default
    @OneToMany(
            mappedBy = "subsidiary",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Set<EmployeeEntity> employees = new HashSet<>();
}
