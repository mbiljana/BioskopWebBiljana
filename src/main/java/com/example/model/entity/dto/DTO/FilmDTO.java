package com.example.model.entity.dto.DTO;

import java.io.Serializable;

public class FilmDTO implements Serializable {
    private Long id;
    private String naziv;
    private String opis;
    private String zanr;
    private String trajanje;
    private Double ocena;


    public FilmDTO(String naziv, String opis, String zanr, String trajanje, Double ocena) {
        this.naziv = naziv;
        this.opis = opis;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.ocena = ocena;
    }

    public FilmDTO(Long id, String naziv, String opis, String zanr, String trajanje, Double ocena) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.ocena = ocena;
    }

    public FilmDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }
}
