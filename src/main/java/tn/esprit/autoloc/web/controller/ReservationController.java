package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Reservation> createReservations(@RequestBody List<Reservation> reservations) {
        return reservationService.addReservations(reservations);
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable("id") Long idReservation) {
        reservationService.removeReservation(idReservation);
    }

    // ---- Recherche avancée ----

    @GetMapping("/by-date-debut-after")
    public List<Reservation> getByDateDebutAfter(@RequestParam String date) {
        return reservationService.findByDateDebutAfter(LocalDate.parse(date));
    }

    @GetMapping("/by-date-fin-before")
    public List<Reservation> getByDateFinBefore(@RequestParam String date) {
        return reservationService.findByDateFinBefore(LocalDate.parse(date));
    }

    @GetMapping("/by-client")
    public List<Reservation> getReservationsByClient(@RequestParam Long idClient) {
        return reservationService.getReservationsByClient(idClient);
    }

    @GetMapping("/count-by-client")
    public List<Object[]> countReservationsByClient() {
        return reservationService.countReservationsByClient();
    }
}
