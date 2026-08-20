package dk.elektrostorage.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leverandoer")

public class Leverandoer {


    @Id
    private int leverandoerId;

    private String navn;
    private String adresse;

}
