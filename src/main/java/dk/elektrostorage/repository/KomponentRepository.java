package dk.elektrostorage.repository;

import dk.elektrostorage.model.Komponent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KomponentRepository extends JpaRepository<Komponent, Integer> {

}