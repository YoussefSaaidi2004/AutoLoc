package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // ---- Associations ----

    // Vehicule * --- 1 Agence
    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    // Vehicule 1 --- * Maintenance
    @OneToMany(mappedBy = "vehicule")
    @Builder.Default
    private List<Maintenance> maintenances = new ArrayList<>();

    // Vehicule * --- * Equipement
    @ManyToMany
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    @Builder.Default
    private Set<Equipement> equipements = new HashSet<>();

    // Vehicule 1 --- * Reservation
    @OneToMany(mappedBy = "vehicule")
    @Builder.Default
    private List<Reservation> reservations = new ArrayList<>();
}
