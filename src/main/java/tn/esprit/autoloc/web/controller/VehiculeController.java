import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestParam;
    // ---- Recherche avancée ----

    // Partie I
    @GetMapping("/by-marque")
    public List<Vehicule> getByMarque(@RequestParam String marque) {
        return vehiculeService.findByMarque(marque);
    }

    @GetMapping("/by-categorie")
    public List<Vehicule> getByCategorie(@RequestParam CategorieVehicule categorie) {
        return vehiculeService.findByCategorie(categorie);
    }

    @GetMapping("/by-statut")
    public List<Vehicule> getByStatut(@RequestParam StatutVehicule statut) {
        return vehiculeService.findByStatut(statut);
    }

    // Partie II
    @GetMapping("/by-marque-like")
    public List<Vehicule> getByMarqueLike(@RequestParam String marque) {
        return vehiculeService.findByMarqueContaining(marque);
    }

    @GetMapping("/by-modele-starts")
    public List<Vehicule> getByModeleStarts(@RequestParam String modele) {
        return vehiculeService.findByModeleStartingWith(modele);
    }

    // Partie III
    @GetMapping("/tarif-gt")
    public List<Vehicule> getByTarifGreater(@RequestParam BigDecimal tarif) {
        return vehiculeService.findByTarifJournalierGreaterThan(tarif);
    }

    @GetMapping("/tarif-lt")
    public List<Vehicule> getByTarifLess(@RequestParam BigDecimal tarif) {
        return vehiculeService.findByTarifJournalierLessThan(tarif);
    }

    @GetMapping("/tarif-gte")
    public List<Vehicule> getByTarifGreaterEqual(@RequestParam BigDecimal tarif) {
        return vehiculeService.findByTarifJournalierGreaterThanEqual(tarif);
    }

    // Partie IV
    @GetMapping("/by-marque-statut")
    public List<Vehicule> getByMarqueAndStatut(@RequestParam String marque, @RequestParam StatutVehicule statut) {
        return vehiculeService.findByMarqueAndStatut(marque, statut);
    }

    @GetMapping("/by-categories")
    public List<Vehicule> getByCategories(@RequestParam List<CategorieVehicule> categories) {
        return vehiculeService.findByCategorieIn(categories);
    }

    @GetMapping("/by-marque-tarif-lt")
    public List<Vehicule> getByMarqueAndTarifLess(@RequestParam String marque, @RequestParam BigDecimal tarif) {
        return vehiculeService.findByMarqueAndTarifJournalierLessThan(marque, tarif);
    }

    // Partie VI
    @GetMapping("/disponibles-tarif-asc")
    public List<Vehicule> getDisponiblesOrderByTarifAsc() {
        return vehiculeService.findByStatutOrderByTarifJournalierAsc(StatutVehicule.DISPONIBLE);
    }

    @GetMapping("/tarif-desc")
    public List<Vehicule> getAllOrderByTarifDesc() {
        return vehiculeService.findAllByOrderByTarifJournalierDesc();
    }
package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/{id}")
    public Vehicule getVehicule(@PathVariable("id") Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicule createVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Vehicule> createVehicules(@RequestBody List<Vehicule> vehicules) {
        return vehiculeService.addVehicules(vehicules);
    }

    @PutMapping
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicule(@PathVariable("id") Long idVehicule) {
        vehiculeService.removeVehicule(idVehicule);
    }

    // ---- Affectation Vehicule <-> Agence ----

    @PutMapping("/{idVehicule}/affecter/{idAgence}")
    public Vehicule affecterVehicule(@PathVariable Long idVehicule,
                                     @PathVariable Long idAgence) {
        return vehiculeService.affecterVehicule(idVehicule, idAgence);
    }

    // ---- Affectation Vehicule <-> Equipement ----

    @PutMapping("/{idVehicule}/equipement/affecter/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule,
                                       @PathVariable Long idEquipement) {
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @PutMapping("/{idVehicule}/equipement/desaffecter/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable Long idVehicule,
                                          @PathVariable Long idEquipement) {
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }
}

