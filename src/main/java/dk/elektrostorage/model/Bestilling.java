package dk.elektrostorage.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "bestilling")

public class Bestilling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int bestillingsId;

    @ManyToOne
    private Leverandoer leverandoer;

    private String trackingKode;
    private LocalDate sendtDato;

    @Column(name = "forventet_levering")
    private LocalDate forventetDato;

    private LocalDate modtagetDato;

    @OneToMany(mappedBy = "bestilling", cascade = CascadeType.ALL)
    private List<KomponentAntal> komponenter = new ArrayList<>();

    public int getNumberofKomponenter() {
        return komponenter.size();
    }

    public List<KomponentAntal> getKomponenter() {
        return komponenter;
    }

    public LocalDate getSendtDato() {
        return sendtDato;
    }

    public void setSendtDato(LocalDate sendtDato) {
        this.sendtDato = sendtDato;
    }

    public Leverandoer getLeverandoer() {
        return leverandoer;
    }

    public void setLeverandoer(Leverandoer leverandoer) {
        this.leverandoer = leverandoer;
    }


    public LocalDate getModtagetDato() {
        return modtagetDato;
    }

    public int getId() {
        return bestillingsId;
    }

    public void setBestillingsId(int bestillingsId) {
        this.bestillingsId = bestillingsId;
    }

    public String getTrackingKode() {
        return trackingKode;
    }

    public void setTrackingKode(String trackingKode) {
        this.trackingKode = trackingKode;
    }

    public LocalDate getForventetDato() {
        return forventetDato;
    }

    public void setForventetDato(LocalDate forventetDato) {
        this.forventetDato = forventetDato;
    }

    public void setModtagetDato(LocalDate modtagetDato) {
        this.modtagetDato = modtagetDato;
    }

}
