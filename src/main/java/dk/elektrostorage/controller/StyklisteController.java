package dk.elektrostorage.controller;

import dk.elektrostorage.model.Stykliste;
import dk.elektrostorage.service.StyklisteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/styklister")

public class StyklisteController {


    private final StyklisteService styklisteService;

    public StyklisteController(StyklisteService styklisteService) {
        this.styklisteService = styklisteService;
    }

    @GetMapping
    public List<Stykliste> getAllStyklister() {
        return styklisteService.getAllStyklister();
    }
}
