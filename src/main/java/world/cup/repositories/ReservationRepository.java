package world.cup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	Optional<Reservation> findById(Long id);
}
