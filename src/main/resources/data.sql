INSERT INTO Bioskop(id, adresa, broj_telefona_centrale, e_mail, naziv) values (1, 'Bulevar Oslobodjenja', 14, 'bioskop1@gmail.com', 'Bioskop1');
INSERT INTO Bioskop(id, adresa, broj_telefona_centrale, e_mail, naziv) values (2, 'Marsala Tita', 32, 'bioskop2@gmail.com', 'Bioskop2');
INSERT INTO Bioskop(id, adresa, broj_telefona_centrale, e_mail, naziv) values (5, 'Zarka Zrenjanina', 2, 'bioskop5@gmail.com', 'Bioskop5');

INSERT INTO Korisnik( type,id,ime, prezime,korisnicko_ime,lozinka,e_mail,datum_rodjenja,kontakt_telefon, uloga,aktivan) values
('Gledalac', 1, 'Biljana', 'Marinkov', 'mbiljana', 'mbiljana123', 'mbiljana99@gmail.com', '1999-05-02', '063548952', 0, true);
INSERT INTO Korisnik( type,id,ime, prezime,korisnicko_ime,lozinka,e_mail,datum_rodjenja,kontakt_telefon, uloga,aktivan) values
('Gledalac', 12, 'Ana', 'Aleksic', 'ana', '145879', 'ana@gmail.com', '2000-05-04', '063546156', 0, true);
INSERT INTO Korisnik(type, id,ime, prezime,korisnicko_ime,lozinka,e_mail,datum_rodjenja,kontakt_telefon, uloga,aktivan) values
('Menadzer', 45, 'Jovan', 'Jovanovic', 'jovanovicj', 'menadzer1', 'jovanovic@gmail.com', '1991-08-07', '154845522', 1, true);
INSERT INTO Korisnik(type, id,ime, prezime,korisnicko_ime,lozinka,e_mail,datum_rodjenja,kontakt_telefon, uloga,aktivan) values
('Administrator', 2, 'Miljana', 'Savic', 'msavic', 'miljana55', 'msavic@gmail.com', '1995-05-05', '78954632', 0, true);

INSERT INTO Sala(id, kapacitet, oznaka_sale) values (1,46,'Sala A1');
INSERT INTO Sala(id, kapacitet, oznaka_sale) values (2,22,'Sala 3D');
INSERT INTO Sala(id, kapacitet, oznaka_sale) values (3,78,'Sala C15');
INSERT INTO Sala(id, kapacitet, oznaka_sale) values (4,78,'Sala 6D');

INSERT INTO Film(naziv,zanr,opis,trajanje)values('Interstellar', 'SciFi','Tim naučnika istraživača putuje kroz crvotočinu u svemiru da bi pokušali da osiguraju opstanak ljudske vrste','2h 50min');
INSERT INTO Film(naziv,zanr,opis,trajanje)values('Harry Potter and the Sorcerers Stone', 'Fantasy','Dečak upisuje školu čarolije,tamo saznaje stvari o sebi, svojoj porodici i opasnosti koja mu preti','2h 30min');
INSERT INTO Film(naziv,zanr,opis,trajanje)values('Dead poets society', 'Drama', 'Nastavnik u školi pokušava da koristi poeziju da bi svojim učenicima pokazao novi vid samoizražavanja','2h 8min');
INSERT INTO Film(naziv,zanr,opis,trajanje)values('The Imitiaition Game','Biografija, Drama', 'Film prati život Alana Tjuringa,genijalnog matematičara,koji je za vreme Drugog Svetskog rata pokušavao da otkrije nemački Enigma kod','1h 54 min');

INSERT INTO Filmovi_bioskop(film_id,bioskop_id)values(1,1);
INSERT INTO Filmovi_bioskop(film_id,bioskop_id)values(1,2);
INSERT INTO Filmovi_bioskop(film_id,bioskop_id)values(1,5);
INSERT INTO Filmovi_bioskop(film_id,bioskop_id)values(4,1);
INSERT INTO Filmovi_bioskop(film_id,bioskop_id)values(3,5);
INSERT INTO Filmovi_bioskop(film_id,bioskop_id)values(2,1);
INSERT INTO Filmovi_bioskop(film_id,bioskop_id)values(3,2);

INSERT INTO Filmovi_sala(sala_id,film_id)values(1,1);
INSERT INTO Filmovi_sala(sala_id,film_id)values(2,2);
INSERT INTO Filmovi_sala(sala_id,film_id)values(2,3);
INSERT INTO Filmovi_sala(sala_id,film_id)values(3,4);
INSERT INTO Filmovi_sala(sala_id,film_id)values(3,3);
INSERT INTO Filmovi_sala(sala_id,film_id)values(4,2);

INSERT INTO Lista_projekcija(broj_rezervisanih,cena,dan,naziv,pocetak,zanr,film_id,sala_id)values(3,250,'2020-09-12','Interstellar','18:00h','SciFi',1,1);
INSERT INTO Lista_projekcija(broj_rezervisanih,cena,dan,naziv,pocetak,zanr,film_id,sala_id)values(15,180,'2020-10-30','The imitation Game','20:00h','Biografija i Drama',4,3);

INSERT INTO Ocena(ocena,film_id,gledalac_id)values(5,2,1);
INSERT INTO Ocena(ocena,film_id,gledalac_id)values(5,1,12);
INSERT INTO Ocena(ocena,film_id,gledalac_id)values(4,4,1);

INSERT INTO Rezervisani_filmovi(gledalac_id,projekcija_id)values(1,1);
INSERT INTO Rezervisani_filmovi(gledalac_id,projekcija_id)values(12,2);






