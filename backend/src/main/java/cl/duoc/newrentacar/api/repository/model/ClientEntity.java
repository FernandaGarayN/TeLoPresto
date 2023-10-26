package cl.duoc.newrentacar.api.repository.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 30, name = "username")
    private String username;
    @Column(nullable = false, length = 10, name = "rut")
    private String rut;
    @Column(nullable = false, length = 50, name = "first_name")
    private String firstName;
    @Column(nullable = false, length = 50, name = "last_name")
    private String lastName;
    @Column(nullable = false, length = 50, name = "email")
    private String email;
    @Column(nullable = false, name = "phone_number")
    private Integer phoneNumber;
    @Column(nullable = false, length = 200, name = "address")
    private String address;
    @Column(nullable = false, name = "gift_points")
    private Integer points;
    @Builder.Default
    @OneToMany(
            mappedBy = "client",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Set<ReservationEntity> reservations = new HashSet<>();
}
