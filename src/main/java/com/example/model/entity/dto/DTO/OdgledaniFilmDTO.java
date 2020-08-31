package com.example.model.entity.dto.DTO;

import java.io.Serializable;

public class OdgledaniFilmDTO implements Serializable {
    private String naziv;
    private int ocena;

    public OdgledaniFilmDTO(String naziv, int ocena) {
        this.naziv = naziv;
        this.ocena = ocena;
    }

    public OdgledaniFilmDTO() {
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
