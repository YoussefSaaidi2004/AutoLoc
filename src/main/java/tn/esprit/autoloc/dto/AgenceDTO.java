package tn.esprit.autoloc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgenceDTO {
    private Long idAgence;
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;
}
