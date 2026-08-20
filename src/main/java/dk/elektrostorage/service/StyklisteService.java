package dk.elektrostorage.service;

import dk.elektrostorage.model.Stykliste;
import dk.elektrostorage.repository.StyklisteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyklisteService {

    private final StyklisteRepository styklisteRepository;

    public StyklisteService (StyklisteRepository styklisteRepository){
        this.styklisteRepository = styklisteRepository;
    }

    public List<Stykliste> getAllStyklister() {
        return styklisteRepository.findAll();
    }


}

