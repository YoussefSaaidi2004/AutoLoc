package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Vehicule;

@Repository
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;
import java.util.List;

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
}
