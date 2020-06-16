INSERT INTO Bioskop(id, adresa, broj_telefona_centrale, e_mail, naziv) values (1, 'Bulevar Oslobodjenja', 14, 'bioskop1@gmail.com', 'Bioskop1');
INSERT INTO Bioskop(id, adresa, broj_telefona_centrale, e_mail, naziv) values (2, 'Marsala Tita', 32, 'bioskop2@gmail.com', 'Bioskop2');
INSERT INTO Bioskop(id, adresa, broj_telefona_centrale, e_mail, naziv) values (5, 'Zarka Zrenjanina', 2, 'bioskop5@gmail.com', 'Bioskop5');
INSERT INTO Korisnik(type, id,ime, prezime,korisnicko_ime,lozinka,e_mail,datum_rodjenja,kontakt_telefon, uloga,aktivan) values
('Gledalac', 1, 'Biljana', 'Marinkov', 'mbiljana', 'mbiljana123', 'mbiljana99@gmail.com', '1999-05-02', '063548952', 0, true);
INSERT INTO Korisnik(type, id,ime, prezime,korisnicko_ime,lozinka,e_mail,datum_rodjenja,kontakt_telefon, uloga,aktivan) values
('Gledalac', 12, 'Ana', 'Aleksic', 'ana', '145879', 'ana@gmail.com', '2000-05-04', '063546156', 0, true);
INSERT INTO Korisnik(type, id,ime, prezime,korisnicko_ime,lozinka,e_mail,datum_rodjenja,kontakt_telefon, uloga,aktivan) values
('Menadzer', 45, 'Jovan', 'Jovanovic', 'jovanovicj', 'menadzer1', 'jovanovic@gmail.com', '1991-08-07', '154845522', 1, true);
INSERT INTO Korisnik(type, id,ime, prezime,korisnicko_ime,lozinka,e_mail,datum_rodjenja,kontakt_telefon, uloga,aktivan) values
('Administrator', 2, 'Miljana', 'Savic', 'msavic', 'miljana55', 'msavic@gmail.com', '1995-05-05', '78954632', 0, true);
INSERT INTO Sala(id, kapacitet, oznaka_sale) values (1,46,'Sala A1');
INSERT INTO Sala(id, kapacitet, oznaka_sale) values (2,22,'Sala 3D');
INSERT INTO Sala(id, kapacitet, oznaka_sale) values (3,78,'Sala C15');