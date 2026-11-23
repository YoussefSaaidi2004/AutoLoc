package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
	// Partie I
	List<Vehicule> findByMarque(String marque);
	List<Vehicule> findByCategorie(CategorieVehicule categorie);
	List<Vehicule> findByStatut(StatutVehicule statut);

	// Partie II
	List<Vehicule> findByMarqueContainingIgnoreCase(String marque);
	List<Vehicule> findByModeleStartingWithIgnoreCase(String modele);

	// Partie III
	List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);
	List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif);
	List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif);

	// Partie IV
	List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
	List<Vehicule> findByCategorieIn(List<CategorieVehicule> categories);
	List<Vehicule> findByMarqueAndTarifJournalierLessThan(String marque, BigDecimal tarif);

	// Partie VI
	List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut);
	List<Vehicule> findAllByOrderByTarifJournalierDesc();

	// Recherche par agence
	List<Vehicule> findByAgence_IdAgence(Long idAgence);

	// Statistiques
	@Query("SELECT v.agence.idAgence, COUNT(v) FROM Vehicule v WHERE v.agence IS NOT NULL GROUP BY v.agence.idAgence")
	List<Object[]> countVehiculesByAgence();
}
