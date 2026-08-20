package dk.elektrostorage.service;

import dk.elektrostorage.model.Komponent;
import dk.elektrostorage.repository.KomponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomponentService {

    private final KomponentRepository komponentRepository;

    public KomponentService (KomponentRepository komponentRepository) {
        this.komponentRepository = komponentRepository;
    }

    public List<Komponent> getAllKomponenter() {
        return komponentRepository.findAll();
    }

    public Komponent addKomponent(Komponent komponent) {
        return komponentRepository.save(komponent);
    }

    public void markAsUdgaaet(int komponentId) {
        Komponent komponent = komponentRepository.findById(komponentId)
                .orElseThrow();

        komponent.setUdgaaet(true);

        komponentRepository.save(komponent);
    }




}
