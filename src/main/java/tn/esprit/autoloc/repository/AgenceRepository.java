package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Agence;

@Repository
import java.util.List;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
	// Partie I
	List<Agence> findByVille(String ville);

	// Partie II
	List<Agence> findByNomEndingWithIgnoreCase(String nom);
}
