package dk.elektrostorage.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "komponent")

public class Komponent {

    @Id
    private int komponentId;

    @ManyToOne
    private Leverandoer leverandoer;

    private String eksterntVarenummer;

    private boolean udgaaet;


    public int getKomponentId() {
        return komponentId;
    }

    public String getEksterntVarenummer() {
        return eksterntVarenummer;
    }

    public boolean isUdgaaet() {
        return udgaaet;
    }

    public void setUdgaaet(boolean udgaaet) {
        this.udgaaet = udgaaet;
    }

}
