package bdbt_bada_project.SpringApplication.repository;

import bdbt_bada_project.SpringApplication.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
