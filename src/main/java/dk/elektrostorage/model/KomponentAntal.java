package dk.elektrostorage.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "komponentantal")

public class KomponentAntal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonIgnore
    private Bestilling bestilling;

    @ManyToOne
    private Komponent komponent;

    private int antal;

    public Bestilling getBestilling() {
        return bestilling;
    }

    public void setBestilling(Bestilling bestilling) {
        this.bestilling = bestilling;
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

