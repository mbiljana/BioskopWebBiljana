package com.example.model.entity.dto.DTO;

import java.io.Serializable;

public class PrijavaKorisnikaDTO implements Serializable {
    private String korisnickoIme;
    private String lozinka;

    public PrijavaKorisnikaDTO(String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public PrijavaKorisnikaDTO() {
    }

    @Override
    public String toString() {
        return "PrijavaKorisnikaDTO{" +
                "korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                '}';
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
