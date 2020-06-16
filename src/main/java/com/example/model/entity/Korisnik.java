package com.example.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)

public class Korisnik implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;

    @Column(nullable = false)
    private String korisnickoIme;
    @Column(nullable = false)
    private String lozinka;
    @Column(nullable = false)
    private String ime;
    @Column(nullable = false)
    private String prezime;
    @Column
    private String kontaktTelefon;
    @Column
    private String e_mail;
    @Column
    private Date datumRodjenja;
    @Column(nullable = false)
    private EnumUloga uloga;
    @Column(nullable = false)
    private Boolean aktivan;

    public Korisnik() {

    }


    public Korisnik(Long id, String korisnickoIme, String lozinka, String ime,
                    String prezime, String kontaktTelefon, String e_mail,
                    Date datumRodjenja, EnumUloga uloga, Boolean aktivan) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.e_mail = e_mail;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
        this.aktivan = aktivan;
    }

    public Korisnik(String korisnicko_ime, String lozinka, String ime,
                    String prezime, String kontakt_telefon, String e_mail,
                    Date datum_rodjenja, EnumUloga uloga, Boolean aktivan) {
        this.korisnickoIme = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontakt_telefon;
        this.e_mail = e_mail;
        this.datumRodjenja = datum_rodjenja;
        this.uloga = uloga;
        this.aktivan = aktivan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnicko_ime() {
        return korisnickoIme;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnickoIme = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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
        return kontaktTelefon;
    }

    public void setKontakt_telefon(String kontakt_telefon) {
        this.kontaktTelefon = kontakt_telefon;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Date getDatum_rodjenja() {
        return datumRodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datumRodjenja = datum_rodjenja;
    }

    public EnumUloga getUloga() {
        return uloga;
    }

    public void setUloga(EnumUloga uloga) {
        this.uloga = uloga;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }


}
