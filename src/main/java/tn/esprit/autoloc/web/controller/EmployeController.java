package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @GetMapping("/{id}")
    public Employe getEmploye(@PathVariable("id") Long idEmploye) {
        return employeService.retrieveEmploye(idEmploye);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe createEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Employe> createEmployes(@RequestBody List<Employe> employes) {
        return employeService.addEmployes(employes);
    }

    @PutMapping
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeService.updateEmploye(employe);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmploye(@PathVariable("id") Long idEmploye) {
        employeService.removeEmploye(idEmploye);
    }
}
