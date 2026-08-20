# ElektroStorage

ElektroStorage er et lagerstyringssystem til håndtering af komponenter,
bestillinger, lager og styklister.

## Funktioner

### Components
- Liste komponenter
- Tilføje komponenter
- Markere komponenter som udgået

### Orders
- Liste bestillinger
- Tilføje komponenter og antal til bestillinger
- Markere bestillinger som sendt
- Forhindre ændringer efter en bestilling er sendt

### Inventory
- Liste komponenter, som er modtaget via bestillinger
- Indsende lageroptælling af en bestemt komponent

### Assemblies
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

- `/components`
- `/orders`
- `/inventory`
- `/assemblies`
