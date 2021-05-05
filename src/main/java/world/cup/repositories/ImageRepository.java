package world.cup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import world.cup.models.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long>{
	Optional<ImageModel> findByName(String name);
}
