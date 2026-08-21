package dk.elektrostorage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "styklistekomponent")
public class StyklisteKomponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "stykliste_id")
    private Stykliste stykliste;

    @ManyToOne
    @JoinColumn(name = "komponent_id")
    private Komponent komponent;

    private int antal;

    public int getId() {
        return id;
    }

    public Stykliste getStykliste() {
        return stykliste;
    }

    public void setStykliste(Stykliste stykliste) {
        this.stykliste = stykliste;
    }

    public Komponent getKomponent() {
        return komponent;
    }

    public void setKomponent(Komponent komponent) {
        this.komponent = komponent;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }
}