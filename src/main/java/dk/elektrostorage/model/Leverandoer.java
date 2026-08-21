package dk.elektrostorage.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leverandoer")

public class Leverandoer {

    @Id
    @Column(name = "id")
    private int leverandoerId;

    private String navn;
    private String adresse;

    public int getId() {
        return leverandoerId;
    }

    public void setId(int id) {
        this.leverandoerId = id;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }
}
