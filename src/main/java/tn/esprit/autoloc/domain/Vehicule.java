package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
// JPA
@Entity
@Table(name = "vehicule")
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;
    @Column(nullable = false, length = 50)
    private String marque;
    @Column(nullable = false, length = 50)
    private String modele;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;
}
