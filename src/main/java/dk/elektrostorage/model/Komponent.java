package dk.elektrostorage.model;


import jakarta.persistence.*;

@Entity
@Table(name = "komponent")

public class Komponent {

    @Id
    @Column(name = "id")
    private int id;

    private String navn;

    @Column(name = "eksternt_varenr")
    private String eksterntVarenr;

    private boolean udgaaet;

    @ManyToOne
    @JoinColumn(name = "leverandoer_id")
    private Leverandoer leverandoer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEksterntVarenr() {
        return eksterntVarenr;
    }

    public void setEksterntVarenr(String eksterntVarenr) {
        this.eksterntVarenr = eksterntVarenr;
    }

    public boolean isUdgaaet() {
        return udgaaet;
    }

    public void setUdgaaet(boolean udgaaet) {
        this.udgaaet = udgaaet;
    }

    public Leverandoer getLeverandoer() {
        return leverandoer;
    }

    public void setLeverandoer(Leverandoer leverandoer) {
        this.leverandoer = leverandoer;
    }

}