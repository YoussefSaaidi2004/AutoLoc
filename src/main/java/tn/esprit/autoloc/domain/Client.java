package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// JPA
@Entity
@Table(name = "client")
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    @Column(nullable = false, length = 50)
    private String nom;
    @Column(nullable = false, length = 50)
    private String prenom;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false, length = 20)
    private String telephone;
    @Column(nullable = false, unique = true, length = 30)
    private String numPermis;
    @Column(nullable = false)
    private LocalDate dateInscription;

    // ---- Associations ----

    // Client 1 --- * Reservation
    @OneToMany(mappedBy = "client")
    @Builder.Default
    private List<Reservation> reservations = new ArrayList<>();
}
