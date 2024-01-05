package bdbt_bada_project.SpringApplication.repository;

import bdbt_bada_project.SpringApplication.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
