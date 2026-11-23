package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.autoloc.domain.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {
	@Query("SELECT c.idClient, COUNT(r) FROM Client c LEFT JOIN c.reservations r GROUP BY c.idClient")
	List<Object[]> countReservationsByClient();
}
