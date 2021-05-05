package world.cup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
	Optional<Hotel> findById(Long id);
}
