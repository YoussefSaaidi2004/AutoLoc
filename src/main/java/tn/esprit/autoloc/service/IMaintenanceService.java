package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.time.LocalDate;
import java.util.List;

public interface IMaintenanceService {
    List<Maintenance> retrieveAllMaintenances();
    Maintenance addMaintenance(Maintenance m);
    Maintenance updateMaintenance(Maintenance m);
    Maintenance retrieveMaintenance(Long idMaintenance);
    void removeMaintenance(Long idMaintenance);
    List<Maintenance> addMaintenances(List<Maintenance> maintenances);

    // Recherche avancée
    List<Maintenance> findByDateFinBetween(LocalDate start, LocalDate end);
}
