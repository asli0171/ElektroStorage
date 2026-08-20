package dk.elektrostorage.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "bestilling")

public class Bestilling {

    @Id
    private int bestillingsId;

    @ManyToOne
    private Leverandoer leverandoer;

    private String trackingKode;
    private LocalDate sendtDato;
    private LocalDate forventetDato;
    private LocalDate modtagetDato;

    @OneToMany
    private List<KomponentAntal> komponenter = new ArrayList<>();

    public int getNumberofKomponenter() {
        return komponenter.size();
}
}
