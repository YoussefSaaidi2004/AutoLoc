package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Reservation;

@Repository
import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	// Partie V
	List<Reservation> findByDateDebutAfter(LocalDate date);
	List<Reservation> findByDateFinBefore(LocalDate date);
}
