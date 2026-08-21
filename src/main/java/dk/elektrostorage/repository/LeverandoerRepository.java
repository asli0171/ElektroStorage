package dk.elektrostorage.repository;

import dk.elektrostorage.model.Leverandoer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeverandoerRepository extends JpaRepository<Leverandoer, Integer> {
    Optional<Leverandoer> findByNavn(String navn);
}

