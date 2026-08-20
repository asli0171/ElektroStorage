package dk.elektrostorage.repository;

import dk.elektrostorage.model.Bestilling;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BestillingRepository extends JpaRepository<Bestilling, Integer> {

}