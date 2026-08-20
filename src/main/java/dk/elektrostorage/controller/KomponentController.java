package dk.elektrostorage.controller;

import dk.elektrostorage.model.Komponent;
import dk.elektrostorage.service.KomponentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/komponenter")

public class KomponentController {

    private final KomponentService komponentService;

    public KomponentController(KomponentService komponentService) {
        this.komponentService = komponentService;
    }

    @GetMapping
    public List<Komponent> getAllKomponenter() {
        return komponentService.getAllKomponenter();
    }

    @PostMapping
    public Komponent addKomponent(@RequestBody Komponent komponent) {
        return komponentService.addKomponent(komponent);
    }

    @PutMapping("/{id}/udgaaet")
    public void markAsUdgaaet(@PathVariable int id) {
        komponentService.markAsUdgaaet(id);
    }
}
