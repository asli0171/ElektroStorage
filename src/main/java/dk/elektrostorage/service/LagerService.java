package dk.elektrostorage.service;

import dk.elektrostorage.model.Bestilling;
import dk.elektrostorage.model.Komponent;
import dk.elektrostorage.model.KomponentAntal;
import dk.elektrostorage.model.Lager;
import dk.elektrostorage.repository.BestillingRepository;
import dk.elektrostorage.repository.LagerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LagerService {


    private final LagerRepository lagerRepository;
    private final BestillingRepository bestillingRepository;

    public LagerService(LagerRepository lagerRepository, BestillingRepository bestillingRepository) {

        this.lagerRepository = lagerRepository;
        this.bestillingRepository = bestillingRepository;
    }

    public List<Komponent> getAllKomponenter() {

        List<Bestilling> bestillinger = bestillingRepository.findAll();

        List<Komponent> komponenter = new ArrayList<>();

        for (Bestilling bestilling : bestillinger) {

            if (bestilling.getModtagetDato() != null) {

                for (KomponentAntal komponentAntal : bestilling.getKomponenter()) {
                    komponenter.add(komponentAntal.getKomponent());
                }
            }
        }

        return komponenter;
    }

    public Lager registrerOptaelling(Lager lager) {
        return lagerRepository.save(lager);
    }

}

