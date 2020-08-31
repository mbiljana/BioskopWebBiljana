package com.example.model.entity.dto.DTO;

import java.io.Serializable;

public class UlogovaniKorisnikDTO implements Serializable {
    private String korisnickoIme;
    private String uloga;

    public UlogovaniKorisnikDTO(String korisnickoIme, String uloga) {
        this.korisnickoIme = korisnickoIme;
        this.uloga = uloga;
    }

    public UlogovaniKorisnikDTO() {
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
}
