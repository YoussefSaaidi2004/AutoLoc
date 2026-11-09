package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // ---- Associations ----

    // Reservation * --- 1 Client
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Reservation * --- 1 Vehicule
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    // Reservation 1 --- 1 Contrat
    @JsonIgnore
    @OneToOne(mappedBy = "reservation")
    private Contrat contrat;
}
