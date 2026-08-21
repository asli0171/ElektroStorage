package dk.elektrostorage.controller;

import dk.elektrostorage.model.Leverandoer;
import dk.elektrostorage.repository.LeverandoerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leverandoerer")
public class LeverandoerController {

    private final LeverandoerRepository leverandoerRepository;

    public LeverandoerController(
            LeverandoerRepository leverandoerRepository) {
        this.leverandoerRepository = leverandoerRepository;
    }

    @GetMapping
    public List<Leverandoer> getAllLeverandoerer() {
        return leverandoerRepository.findAll();
    }
}
