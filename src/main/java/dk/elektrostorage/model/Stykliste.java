package dk.elektrostorage.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stykliste")


public class Stykliste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private List<StyklisteKomponent> komponenter = new ArrayList<>();

    @ManyToOne
    private Komponent resultat;

}