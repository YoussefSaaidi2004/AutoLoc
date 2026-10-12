package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/{id}")
    public Agence getAgence(@PathVariable("id") Long idAgence) {
        return agenceService.retrieveAgence(idAgence);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agence createAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Agence> createAgences(@RequestBody List<Agence> agences) {
        return agenceService.addAgences(agences);
    }

    @PutMapping
    public Agence updateAgence(@RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAgence(@PathVariable("id") Long idAgence) {
        agenceService.removeAgence(idAgence);
    }
}
