package com.example.model.entity.dto.DTO;

public class OcenaDTO {
    Long idOcene;
    Long idFilma;
    Long idKorisnika;
    String korisnickoIme;
    String film;
    double ocena;

    public OcenaDTO() {
    }

    public OcenaDTO(Long idOcene, Long idFilma, Long idKorisnika, String korisnickoIme, String film, double ocena) {
        this.idOcene = idOcene;
        this.idFilma = idFilma;
        this.idKorisnika = idKorisnika;
        this.korisnickoIme = korisnickoIme;
        this.film = film;
        this.ocena = ocena;
    }

    public Long getIdOcene() {
        return idOcene;
    }

    public void setIdOcene(Long idOcene) {
        this.idOcene = idOcene;
    }

    public Long getIdFilma() {
        return idFilma;
    }

    public void setIdFilma(Long idFilma) {
        this.idFilma = idFilma;
    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }
}
