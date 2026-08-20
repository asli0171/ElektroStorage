package dk.elektrostorage.model;


import jakarta.persistence.*;

@Entity
@Table(name = "komponentantal")

public class KomponentAntal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Bestilling bestilling;

    @ManyToOne
    private Komponent komponent;

    private int antal;
}
