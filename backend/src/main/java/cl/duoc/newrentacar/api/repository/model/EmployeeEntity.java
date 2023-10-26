package cl.duoc.newrentacar.api.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50, name = "first_name")
    private String firstName;

    @Column(nullable = false, length = 50, name = "last_name")
    private String lastName;

    @Column(nullable = false, length = 50, name = "position")
    private String position;

    @Column(nullable = false, name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(
            name = "subsidiary_id",
            updatable = false,
            nullable = false
    )
    private SubsidiaryEntity subsidiary;

}
