package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// JPA
@Entity
@Table(name = "agence")
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    @Column(nullable = false, length = 100)
    private String nom;
    @Column(nullable = false, length = 100)
    private String ville;
    @Column(nullable = false, length = 255)
    private String adresse;
    @Column(nullable = false, length = 20)
    private String telephone;

    // ---- Associations ----

    // Agence 1 --- * Vehicule
    @OneToMany(mappedBy = "agence")
    @Builder.Default
    private List<Vehicule> vehicules = new ArrayList<>();

    // Agence 1 --- * Employe
    @OneToMany(mappedBy = "agence")
    @Builder.Default
    private List<Employe> employes = new ArrayList<>();
}
