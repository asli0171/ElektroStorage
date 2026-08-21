package dk.elektrostorage.model;


import jakarta.persistence.*;

@Entity
@Table(name = "lager")

public class Lager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Komponent komponent;

    private int antal;

    private String optaltAf;

    public int getId() {
        return id;
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

    public String getOptaltAf() {
        return optaltAf;
    }

    public void setOptaltAf(String optaltAf) {
        this.optaltAf = optaltAf;
    }


}

