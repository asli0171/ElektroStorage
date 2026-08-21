# ElektroStorage

ElektroStorage er et lagerstyringssystem til håndtering af komponenter,
bestillinger, lager og styklister.

## Funktioner

### Komponenter
- Liste komponenter
- Tilføje komponenter
- Markere komponenter som udgået

### Bestillinger
- Liste bestillinger
- Tilføje komponenter og antal til bestillinger
- Markere bestillinger som sendt
- Forhindre ændringer efter en bestilling er sendt

### Lager
- Liste komponenter, som er modtaget via bestillinger
- Indsende lageroptælling af en bestemt komponent

### Styklister
- Se styklister
- Se komponenter i styklister
- Se antal af hver komponent

## Teknologier

- Java
- Spring Boot
- Spring Data JPA
- Maven
- SQL

## Projektstruktur

- `model` – Entities og relationer
- `repository` – Databaseadgang
- `service` – Forretningslogik
- `controller` – REST API endpoints

## Relationel datamodel

### Tabeller

- Leverandoer
- Komponent
- Bestilling
- KomponentAntal
- Lager
- Stykliste
- StyklisteKomponent

### Relationer

- Leverandoer → Bestilling (1:N)
- Leverandoer → Komponent (1:N)
- Bestilling → KomponentAntal (1:N)
- Komponent → KomponentAntal (1:N)
- Komponent → Lager (1:N)
- Stykliste → StyklisteKomponent (1:N)
- Komponent → StyklisteKomponent (1:N)
- Stykliste → Komponent (N:1)

## REST API


### Komponenter
- `GET /komponenter`
- `POST /komponenter`
- `PUT /komponenter/{id}/udgaaet`

### Bestillinger
- `GET /bestillinger`
- `GET /bestillinger/{id}`
- `POST /bestillinger`
- `POST /bestillinger/komponenter`
- `PUT /bestillinger/{id}/sendt`

### Lager
- `GET /lager`
- `POST /lager`

### Styklister
- `GET /styklister`

### Leverandører
- `GET /leverandoerer`


## Test

REST API'et er testet med JUnit/MockMvc og manuelt med en API-klient.

Alle endpoints er blevet afprøvet, og de automatiserede tests består.
