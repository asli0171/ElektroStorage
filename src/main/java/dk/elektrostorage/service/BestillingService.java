package dk.elektrostorage.service;

import dk.elektrostorage.model.Bestilling;
import dk.elektrostorage.model.Komponent;
import dk.elektrostorage.model.KomponentAntal;
import dk.elektrostorage.model.Leverandoer;
import dk.elektrostorage.repository.BestillingRepository;
import dk.elektrostorage.repository.KomponentRepository;
import dk.elektrostorage.repository.LeverandoerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BestillingService {

    private final BestillingRepository bestillingRepository;
    private final KomponentRepository komponentRepository;
    private final LeverandoerRepository leverandoerRepository;


    public BestillingService (BestillingRepository bestillingRepository, KomponentRepository komponentRepository, LeverandoerRepository leverandoerRepository) {
        this.bestillingRepository = bestillingRepository;
        this.komponentRepository = komponentRepository;
        this.leverandoerRepository = leverandoerRepository;
    }

    public List<Bestilling> getAllBestillinger() {
        return bestillingRepository.findAll();
    }

    public Bestilling addBestilling(Bestilling bestilling) {

        int leverandoerId = bestilling.getLeverandoer().getId();

        Leverandoer leverandoer = leverandoerRepository
                .findById(leverandoerId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Leverandøren findes ikke"
                        )
                );

        bestilling.setLeverandoer(leverandoer);

        return bestillingRepository.save(bestilling);
    }


    public Bestilling addKomponentAntal(
            int bestillingId,
            int komponentId,
            int antal) {

        Bestilling bestilling = bestillingRepository
                .findById(bestillingId)
                .orElseThrow();

        if (bestilling.getSendtDato() != null) {
            throw new IllegalStateException(
                    "Bestillingen er allerede sendt"
            );
        }

        Komponent komponent = komponentRepository
                .findById(komponentId)
                .orElseThrow();

        KomponentAntal komponentAntal = new KomponentAntal();

        komponentAntal.setBestilling(bestilling);
        komponentAntal.setKomponent(komponent);
        komponentAntal.setAntal(antal);

        bestilling.getKomponenter().add(komponentAntal);

        return bestillingRepository.save(bestilling);
    }


    public void markAsSendt(int bestillingsId) {
        Bestilling bestilling = bestillingRepository.findById(bestillingsId)
                .orElseThrow();

        bestilling.setSendtDato(LocalDate.now());

        bestillingRepository.save(bestilling);
    }

    public Bestilling getBestilling(int id) {
        return bestillingRepository.findById(id)
                .orElseThrow();
    }
}
