package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @GetMapping
    public List<Contrat> getAllContrats() {
        return contratService.retrieveAllContrats();
    }

    @GetMapping("/{id}")
    public Contrat getContrat(@PathVariable("id") Long idContrat) {
        return contratService.retrieveContrat(idContrat);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contrat createContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Contrat> createContrats(@RequestBody List<Contrat> contrats) {
        return contratService.addContrats(contrats);
    }

    @PutMapping
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContrat(@PathVariable("id") Long idContrat) {
        contratService.removeContrat(idContrat);
    }
}
