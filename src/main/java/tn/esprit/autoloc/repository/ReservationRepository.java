package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	// Partie V
	List<Reservation> findByDateDebutAfter(LocalDate date);
	List<Reservation> findByDateFinBefore(LocalDate date);

	// Recherche par client
	List<Reservation> findByClient_IdClient(Long idClient);

	// Statistiques
	@Query("SELECT r.client.idClient, COUNT(r) FROM Reservation r WHERE r.client IS NOT NULL GROUP BY r.client.idClient")
	List<Object[]> countReservationsByClient();
}
