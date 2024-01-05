package bdbt_bada_project.SpringApplication.repository;

import bdbt_bada_project.SpringApplication.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {

}