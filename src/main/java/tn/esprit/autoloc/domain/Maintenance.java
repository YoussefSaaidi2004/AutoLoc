package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

// JPA
@Entity
@Table(name = "maintenance")
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;
    @Column(nullable = false)
    private LocalDate dateDebut;
    @Column(nullable = false)
    private LocalDate dateFin;
    @Column(length = 500)
    private String description;

    // ---- Associations ----

    // Maintenance * --- 1 Vehicule
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;
}
