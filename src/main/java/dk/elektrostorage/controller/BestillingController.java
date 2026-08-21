package dk.elektrostorage.controller;

import dk.elektrostorage.model.Bestilling;
import dk.elektrostorage.service.BestillingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/{id}")
    public Bestilling getBestilling(@PathVariable int id) {
        return bestillingService.getBestilling(id);
    }


    @PostMapping
    public Bestilling addBestilling(@RequestBody Bestilling bestilling) {
        return bestillingService.addBestilling(bestilling);
    }


    @PostMapping("/komponenter")
    public Bestilling addKomponentAntal(
            @RequestBody Map<String, Object> data) {

        int bestillingId =
                ((Number) data.get("bestillingId")).intValue();

        int komponentId =
                ((Number) data.get("komponentId")).intValue();

        int antal =
                ((Number) data.get("antal")).intValue();

        return bestillingService.addKomponentAntal(
                bestillingId,
                komponentId,
                antal
        );
    }
    @PutMapping("/{id}/sendt")
    public void markAsSendt(@PathVariable int id) {
        bestillingService.markAsSendt(id);
    }
}


