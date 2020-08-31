package com.example.model.entity.dto.DTO;

public class IDOcenaDTO {
    Long id_filma;
    Long id_korisnika;
    double ocena;

    public IDOcenaDTO() {
    }

    public IDOcenaDTO(Long id_filma, Long id_korisnika, double ocena) {
        this.id_filma = id_filma;
        this.id_korisnika = id_korisnika;
        this.ocena = ocena;
    }

    public Long getId_filma() {
        return id_filma;
    }

    public void setId_filma(Long id_filma) {
        this.id_filma = id_filma;
    }

    public Long getId_korisnika() {
        return id_korisnika;
    }

    public void setId_korisnika(Long id_korisnika) {
        this.id_korisnika = id_korisnika;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }
}
