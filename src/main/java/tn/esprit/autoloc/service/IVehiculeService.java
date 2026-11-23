package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;
import java.util.List;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;

public interface IVehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule(Vehicule v);
    Vehicule updateVehicule(Vehicule v);
    Vehicule retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List<Vehicule> addVehicules(List<Vehicule> vehicules);

    // ---- Affectation Vehicule <-> Agence (ManyToOne) ----
    Vehicule affecterVehicule(Long idVehicule, Long idAgence);

    // ---- Affectation Vehicule <-> Equipement (ManyToMany) ----
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

    // Recherche avancée
    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByCategorie(CategorieVehicule categorie);
    List<Vehicule> findByStatut(StatutVehicule statut);
    List<Vehicule> findByMarqueContaining(String marque);
    List<Vehicule> findByModeleStartingWith(String modele);
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);
    List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif);
    List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif);
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
    List<Vehicule> findByCategorieIn(List<CategorieVehicule> categories);
    List<Vehicule> findByMarqueAndTarifJournalierLessThan(String marque, BigDecimal tarif);
    List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut);
    List<Vehicule> findAllByOrderByTarifJournalierDesc();

    // Recherche et statistiques
    List<Vehicule> getVehiculesByAgence(Long idAgence);
    List<Object[]> countVehiculesByAgence();
}
