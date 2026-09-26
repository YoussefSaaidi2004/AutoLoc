package tn.esprit.autoloc.domain;

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
}
