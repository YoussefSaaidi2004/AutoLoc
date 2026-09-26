package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

// JPA
@Entity
@Table(name = "equipement")
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;
    @Column(nullable = false, length = 100)
    private String libelle;
}
