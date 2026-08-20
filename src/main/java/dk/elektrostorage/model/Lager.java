package dk.elektrostorage.model;


import jakarta.persistence.*;

@Entity
@Table(name = "lager.html")

public class Lager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Komponent komponent;

    private int antal;

    private String optaltAf;
}
