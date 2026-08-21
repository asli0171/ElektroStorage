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

    @OneToMany(mappedBy = "stykliste" , cascade = CascadeType.ALL)
    private List<StyklisteKomponent> komponenter = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "komponent_id")
    private Komponent resultat;

    public int getId() {
        return id;
    }

    public List<StyklisteKomponent> getKomponenter() {
        return komponenter;
    }

    public Komponent getResultat() {
        return resultat;
    }

    public void setResultat(Komponent resultat) {
        this.resultat = resultat;
    }
}

