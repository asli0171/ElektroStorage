package dk.elektrostorage.model;


import jakarta.persistence.*;

@Entity
@Table(name = "lageroptælling")

public class Lageroptælling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Komponent komponent;

    private int antal;

    private String optaltAf;
}
