CREATE TABLE Leverandoer (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             navn VARCHAR(100) NOT NULL,
                             adresse VARCHAR(200) NOT NULL
);

CREATE TABLE Komponent (
                           id INT PRIMARY KEY,
                           navn VARCHAR(100) NOT NULL,
                           eksternt_varenr VARCHAR(50) NOT NULL,
                           udgaaet BOOLEAN NOT NULL DEFAULT FALSE,
                           leverandoer_id INT NOT NULL,

                           FOREIGN KEY (leverandoer_id)
                               REFERENCES Leverandoer(id)
);


CREATE TABLE Bestilling (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            leverandoer_id INT NOT NULL,
                            tracking_kode VARCHAR(100),
                            sendt_dato DATE,
                            forventet_levering DATE,
                            modtaget_dato DATE,

                            FOREIGN KEY (leverandoer_id)
                                REFERENCES Leverandoer(id)
);

CREATE TABLE KomponentAntal (
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                bestilling_id INT NOT NULL,
                                komponent_id INT NOT NULL,
                                antal INT NOT NULL,

                                FOREIGN KEY (bestilling_id)
                                    REFERENCES Bestilling(id),

                                FOREIGN KEY (komponent_id)
                                    REFERENCES Komponent(id)
);

CREATE TABLE Lager (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       komponent_id INT NOT NULL,
                       antal INT NOT NULL,
                       optalt_af VARCHAR(100),

                       FOREIGN KEY (komponent_id)
                           REFERENCES Komponent(id)
);

CREATE TABLE Stykliste (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           komponent_id INT NOT NULL,

                           FOREIGN KEY (komponent_id)
                               REFERENCES Komponent(id)
);

CREATE TABLE StyklisteKomponent (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    stykliste_id INT NOT NULL,
                                    komponent_id INT NOT NULL,
                                    antal INT NOT NULL,

                                    FOREIGN KEY (stykliste_id)
                                        REFERENCES Stykliste(id),

                                    FOREIGN KEY (komponent_id)
                                        REFERENCES Komponent(id)
);