package com.example.model.entity.dto.DTO;

import java.io.Serializable;
import java.util.ArrayList;

public class BioskopDTO implements Serializable {

    private Long id;
    private String naziv;
    private String adresa;
    private String brojTelefonaCentrale;
    private String eMail;

    ArrayList<SalaDTO>sale;


    public BioskopDTO(Long id, String naziv, String adresa, String brojTelefonaCentrale, String eMail) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.eMail = eMail;
    }

    public BioskopDTO(String naziv, String adresa, String brojTelefonaCentrale, String eMail, ArrayList<SalaDTO> sale) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.eMail = eMail;
        this.sale = sale;
    }

    public BioskopDTO(String naziv, String adresa, String brojTelefonaCentrale, String eMail) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.eMail = eMail;
    }

    public BioskopDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BioskopDTO{" +
                "naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brojTelefonaCentrale='" + brojTelefonaCentrale + '\'' +
                ", eMail='" + eMail + '\'' +
                ", sale=" + sale +
                '}';
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

    public String getBrojTelefonaCentrale() {
        return brojTelefonaCentrale;
    }

    public void setBrojTelefonaCentrale(String brojTelefonaCentrale) {
        this.brojTelefonaCentrale = brojTelefonaCentrale;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public ArrayList<SalaDTO> getSale() {
        return sale;
    }

    public void setSale(ArrayList<SalaDTO> sale) {
        this.sale = sale;
    }
}
