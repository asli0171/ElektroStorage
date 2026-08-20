package dk.elektrostorage.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "komponent")

public class Komponent {

    @Id
    private int komponentId;

    @ManyToOne
    private Leverandoer leverandoer;

    private String eksterntVarenummer;

    private boolean udgaaet;

}
