package dk.elektrostorage.repository;


import dk.elektrostorage.model.Lager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LagerRepository extends JpaRepository<Lager, Integer> {
    List<Lager> findByOptaltAf(String optaltAf);
}