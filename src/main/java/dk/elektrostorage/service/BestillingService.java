package dk.elektrostorage.service;

import dk.elektrostorage.model.Bestilling;
import dk.elektrostorage.model.KomponentAntal;
import dk.elektrostorage.repository.BestillingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestillingService {

    private final BestillingRepository bestillingRepository;

    public BestillingService (BestillingRepository bestillingRepository) {
        this.bestillingRepository = bestillingRepository;
    }

    public List<Bestilling> getAllBestillinger() {

        return bestillingRepository.findAll();
    }

    public Bestilling addBestilling(Bestilling bestilling) {
        return bestillingRepository.save(bestilling);
    }

    public Bestilling addKomponentAntal(KomponentAntal komponentAntal) {
        Bestilling bestilling = komponentAntal.getBestilling();

        if (bestilling.isSendt()) {
            throw new IllegalStateException("Bestillingen er allerede sendt");
        }

        bestilling.getKomponenter().add(komponentAntal);

        return bestillingRepository.save(bestilling);
    }


    public void markAsSendt(int bestillingsId) {
        Bestilling bestilling = bestillingRepository.findById(bestillingsId)
                .orElseThrow();

        bestilling.setSendt(true);

        bestillingRepository.save(bestilling);
    }

    public Bestilling getBestilling(int id) {
        return bestillingRepository.findById(id)
                .orElseThrow();
    }


}
