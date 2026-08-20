package dk.elektrostorage.model;

import jakarta.persistence.*;

@Entity
@Table(name = "styklistekomponent")
public class StyklisteKomponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Stykliste stykliste;

    @ManyToOne
    private Komponent komponent;

    private int antal;
}
