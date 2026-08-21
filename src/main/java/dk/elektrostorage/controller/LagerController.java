package dk.elektrostorage.controller;

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
    public List<Lager> getAllLager() {
        return lagerService.getAllLager();
    }

    @PostMapping
    public Lager registrerOptaelling(@RequestBody Lager lager){
        return lagerService.registrerOptaelling(lager);
    }

}
