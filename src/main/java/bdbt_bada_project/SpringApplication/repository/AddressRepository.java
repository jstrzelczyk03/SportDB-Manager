package bdbt_bada_project.SpringApplication.repository;

import bdbt_bada_project.SpringApplication.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
