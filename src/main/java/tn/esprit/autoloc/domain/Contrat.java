package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

// JPA
@Entity
@Table(name = "contrat")
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    @Column(nullable = false)
    private LocalDate dateSignature;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;
    @Column(nullable = false)
    private boolean valide;

    // ---- Associations ----

    // Contrat 1 --- 1 Reservation (côté propriétaire)
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // Contrat 1 --- 1 Paiement
    @JsonIgnore
    @OneToOne(mappedBy = "contrat")
    private Paiement paiement;
}
