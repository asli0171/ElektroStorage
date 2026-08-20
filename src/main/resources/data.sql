INSERT INTO Leverandoer (navn, adresse)
VALUES
    ('Eldele Aps', 'Industrivej 10, 2800 Kongens Lyngby'),
    ('Lumi', 'Elektronikvej 25, 2600 Glostrup'),
    ('Nordic Components', 'Teknikvej 7, 2100 København Ø');

INSERT INTO Komponent (id, navn, eksternt_varenr, udgaaet, leverandoer_id)
VALUES
    (101, 'LED 5 mm, rød', '104', FALSE, 1),
    (102, 'Modstand, 1 kOhm', '138', FALSE, 1),
    (103, 'Batteriholder til 9 V batteri', '33', FALSE, 1),
    (104, '9 V batteri', '78', FALSE, 2),
    (105, 'Kondensator 100 uF', '109', FALSE, 2),
    (106, 'Mini-kontakt, sort', '48-B', FALSE, 2),
    (107, 'Kobbertråd 1 meter', '222', FALSE, 3),
    (108, 'Trykknap, rød', '37-E', FALSE, 3),
    (109, 'Lysfølsom sensor', '978', FALSE, 3),
    (110, 'Relæmodul 5 V', '27-C', FALSE, 2),

    (201, 'Lysende LED', 'LYS-001', FALSE, 1);

INSERT INTO Bestilling (leverandoer_id, tracking_kode, sendt_dato, forventet_levering, modtaget_dato)
VALUES
    (1, 'TRK-2026-001', '2026-08-20', '2026-08-25', NULL);

INSERT INTO Bestilling (leverandoer_id, tracking_kode, sendt_dato, forventet_levering, modtaget_dato)
VALUES
    (2, 'TRK-2026-002', '2026-08-01', '2026-08-05', '2026-08-05');

INSERT INTO KomponentAntal (bestilling_id, komponent_id, antal)
VALUES
    (1, 101, 10),
    (1, 102, 10),
    (1, 103, 10);

INSERT INTO KomponentAntal (bestilling_id, komponent_id, antal)
VALUES
    (2, 104, 100);

INSERT INTO Lager (komponent_id, antal)
VALUES
    (101, 25),
    (102, 50),
    (103, 12),
    (104, 100),
    (105, 40),
    (106, 15),
    (107, 75),
    (108, 20),
    (109, 8),
    (110, 5);

INSERT INTO Stykliste (komponent_id)
VALUES (201);

INSERT INTO StyklisteKomponent(stykliste_id, komponent_id, antal)
VALUES
    (1, 101, 1),
    (1, 102, 1),
    (1, 103, 1),
    (1, 104, 1);