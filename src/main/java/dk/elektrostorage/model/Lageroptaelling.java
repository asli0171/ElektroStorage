package dk.elektrostorage.model;


import jakarta.persistence.*;

@Entity
@Table(name = "lageroptaelling")

public class Lageroptaelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Komponent komponent;

    private int antal;

    private String optaltAf;
}
