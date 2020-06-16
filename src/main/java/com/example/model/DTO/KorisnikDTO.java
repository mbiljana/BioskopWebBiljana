package com.example.model.DTO;


import com.example.model.entity.EnumUloga;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;


public class KorisnikDTO implements Serializable {


    private String korisnicko_ime;

    private String lozinka;

    private String ime;

    private String prezime;

    private String kontakt_telefon;

    private String e_mail;

    private Date datum_rodjenja;

    private EnumUloga uloga;

    public KorisnikDTO(String korisnicko_ime, String lozinka, String ime, String prezime,
                       String kontakt_telefon, String e_mail, Date datum_rodjenja, EnumUloga uloga) {
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt_telefon = kontakt_telefon;
        this.e_mail = e_mail;
        this.datum_rodjenja = datum_rodjenja;
        this.uloga = uloga;
    }

    public KorisnikDTO() {
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return "KorisnikDTO{" +
                "korisnicko_ime='" + korisnicko_ime + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", kontakt_telefon='" + kontakt_telefon + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", datum_rodjenja=" + datum_rodjenja +
                ", uloga=" + uloga +
                '}';
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontakt_telefon() {
        return kontakt_telefon;
    }

    public void setKontakt_telefon(String kontakt_telefon) {
        this.kontakt_telefon = kontakt_telefon;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public EnumUloga getUloga() {
        return uloga;
    }

    public void setUloga(EnumUloga uloga) {
        this.uloga = uloga;
    }


}

