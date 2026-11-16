import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;
import java.util.Arrays;
    // ---- Recherche avancée ----

    @Override
    public List<Vehicule> findByMarque(String marque) {
        return vehiculeRepository.findByMarque(marque);
    }

    @Override
    public List<Vehicule> findByCategorie(CategorieVehicule categorie) {
        return vehiculeRepository.findByCategorie(categorie);
    }

    @Override
    public List<Vehicule> findByStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }

    @Override
    public List<Vehicule> findByMarqueContaining(String marque) {
        return vehiculeRepository.findByMarqueContainingIgnoreCase(marque);
    }

    @Override
    public List<Vehicule> findByModeleStartingWith(String modele) {
        return vehiculeRepository.findByModeleStartingWithIgnoreCase(modele);
    }

    @Override
    public List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThan(tarif);
    }

    @Override
    public List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierLessThan(tarif);
    }

    @Override
    public List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThanEqual(tarif);
    }

    @Override
    public List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut) {
        return vehiculeRepository.findByMarqueAndStatut(marque, statut);
    }

    @Override
    public List<Vehicule> findByCategorieIn(List<CategorieVehicule> categories) {
        return vehiculeRepository.findByCategorieIn(categories);
    }

    @Override
    public List<Vehicule> findByMarqueAndTarifJournalierLessThan(String marque, BigDecimal tarif) {
        return vehiculeRepository.findByMarqueAndTarifJournalierLessThan(marque, tarif);
    }


    @Override
    public List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut) {
        return vehiculeRepository.findByStatutOrderByTarifJournalierAsc(statut);
    }

    @Override
    public List<Vehicule> findAllByOrderByTarifJournalierDesc() {
        return vehiculeRepository.findAllByOrderByTarifJournalierDesc();
    }

    // ---- Affectation Vehicule <-> Agence (ManyToOne) ----

    @Override
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        Agence agence = agenceRepository.findById(idAgence).orElse(null);
        if (vehicule != null && agence != null) {
            vehicule.setAgence(agence);
            return vehiculeRepository.save(vehicule);
        }
        return null;
    }

    // ---- Affectation Vehicule <-> Equipement (ManyToMany) ----

    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);
        if (vehicule != null && equipement != null) {
            vehicule.getEquipements().add(equipement);
            return vehiculeRepository.save(vehicule);
        }
        return null;
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);
        if (vehicule != null && equipement != null) {
            vehicule.getEquipements().remove(equipement);
            return vehiculeRepository.save(vehicule);
        }
        return null;
    }
}

