package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

// JPA
@Entity
@Table(name = "reservation")
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    @Column(nullable = false)
    private LocalDate dateDebut;
    @Column(nullable = false)
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutReservation statut;
}
