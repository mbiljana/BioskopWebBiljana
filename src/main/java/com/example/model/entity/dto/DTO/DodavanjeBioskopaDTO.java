package com.example.model.entity.dto.DTO;

import java.io.Serializable;

public class DodavanjeBioskopaDTO implements Serializable {
    private String naziv;
    private String adresa;
    private String brojTelefona;
    private String email;
    private Long idMenadzera;

    public DodavanjeBioskopaDTO(String naziv, String adresa, String brojTelefona, String email, Long idMenadzera) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.idMenadzera = idMenadzera;
    }

    public DodavanjeBioskopaDTO() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdMenadzera() {
        return idMenadzera;
    }

    public void setIdMenadzera(Long idMenadzera) {
        this.idMenadzera = idMenadzera;
    }
}
