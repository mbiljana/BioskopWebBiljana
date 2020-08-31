package com.example.model.entity.dto.DTO;

import java.io.Serializable;

public class OdgledaniFilmOcenaDTO implements Serializable {
    private String naziv;
    private int ocena;

    public OdgledaniFilmOcenaDTO(String naziv, int ocena) {

        this.naziv = naziv;
        this.ocena = ocena;
    }

    public OdgledaniFilmOcenaDTO() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
