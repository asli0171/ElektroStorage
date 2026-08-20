package dk.elektrostorage.controller;

import dk.elektrostorage.model.Bestilling;
import dk.elektrostorage.model.KomponentAntal;
import dk.elektrostorage.service.BestillingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bestillinger")
public class BestillingController {

    private final BestillingService bestillingService;

    public BestillingController(BestillingService bestillingService) {
        this.bestillingService = bestillingService;
    }

    @GetMapping
    public List<Bestilling> getAllBestillinger() {
        return bestillingService.getAllBestillinger();
    }

    @PostMapping
    public Bestilling addBestilling(@RequestBody Bestilling bestilling) {
        return bestillingService.addBestilling(bestilling);
    }

    @PostMapping("/komponenter")
    public Bestilling addKomponentAntal(@RequestBody KomponentAntal komponentAntal) {
        return bestillingService.addKomponentAntal(komponentAntal);
    }

    @PutMapping("/{id}/sendt")
    public void markAsSendt(@PathVariable int id) {
        bestillingService.markAsSendt(id);
    }
}


