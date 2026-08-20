package dk.elektrostorage.controller;

import dk.elektrostorage.model.Komponent;
import dk.elektrostorage.model.Lager;
import dk.elektrostorage.service.LagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lager")

public class LagerController {

    private final LagerService lagerService;

    public LagerController(LagerService lagerService) {
        this.lagerService = lagerService;
    }

    @GetMapping
    public List<Komponent> getAllKomponenter() {
        return lagerService.getAllKomponenter();
    }

    @PostMapping
    public Lager registrerOptaelling(@RequestBody Lager lager){
        return lagerService.registrerOptaelling(lager);
    }

}
