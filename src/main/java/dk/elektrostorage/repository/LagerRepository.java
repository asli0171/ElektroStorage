package dk.elektrostorage.repository;


import dk.elektrostorage.model.Lager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LagerRepository extends JpaRepository<Lager, Integer> {

    Optional<Lager> findByKomponentId(int komponentId);;
}