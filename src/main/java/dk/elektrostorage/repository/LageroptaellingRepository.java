package dk.elektrostorage.repository;


import dk.elektrostorage.model.Lageroptaelling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LageroptaellingRepository extends JpaRepository<Lageroptaelling, Integer> {
    List<Lageroptaelling> findByOptaltAf(String optaltAf);
}