package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

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
}
