package dk.elektrostorage.service;

import dk.elektrostorage.model.Komponent;
import dk.elektrostorage.model.Leverandoer;
import dk.elektrostorage.repository.LeverandoerRepository;
import dk.elektrostorage.repository.KomponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomponentService {

    private final KomponentRepository komponentRepository;
    private final LeverandoerRepository leverandoerRepository;

    public KomponentService (KomponentRepository komponentRepository, LeverandoerRepository leverandoerRepository) {
        this.komponentRepository = komponentRepository;
        this.leverandoerRepository = leverandoerRepository;
    }

    public List<Komponent> getAllKomponenter() {
        return komponentRepository.findAll();
    }

    public Komponent addKomponent(Komponent komponent) {

        String leverandoerNavn = komponent.getLeverandoer().getNavn();

        Leverandoer leverandoer = leverandoerRepository.findByNavn(leverandoerNavn)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Leverandøren findes ikke: " + leverandoerNavn
                                )
                        );

        komponent.setLeverandoer(leverandoer);

        return komponentRepository.save(komponent);
    }

    public void markAsUdgaaet(int komponentId) {
        Komponent komponent = komponentRepository.findById(komponentId)
                .orElseThrow();

        komponent.setUdgaaet(true);

        komponentRepository.save(komponent);
    }




}
