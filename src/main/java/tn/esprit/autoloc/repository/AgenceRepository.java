package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.autoloc.domain.Agence;

import java.util.List;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
	// Partie I
	List<Agence> findByVille(String ville);

	// Partie II
	List<Agence> findByNomEndingWithIgnoreCase(String nom);

	// Statistiques
	@Query("SELECT a.idAgence, COUNT(v) FROM Agence a LEFT JOIN a.vehicules v GROUP BY a.idAgence")
	List<Object[]> countVehiculesByAgence();
}
