package world.cup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long>{
	Optional<Chambre> findById(Long id);
}
