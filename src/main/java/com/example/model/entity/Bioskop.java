package com.example.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bioskop implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;
    @Column
    private String adresa;
    @Column
    private String brojTelefonaCentrale;
    private String eMail;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Menadzer> menadzeri= new HashSet<Menadzer>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sala> sale = new HashSet<Sala>();


    public Bioskop() {

    }

    public Bioskop(Long id, String naziv, String adresa, String brojTelefonaCentrale, String eMail) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.eMail=eMail;
    }
    public Bioskop(String naziv, String adresa, String brojTelefonaCentrale, String eMail) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.eMail=eMail;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefonaCentrale() {
        return brojTelefonaCentrale;
    }

    public void setBroj_telefona_centrale(String broj_telefona_centrale) {
        this.brojTelefonaCentrale = brojTelefonaCentrale;
    }

    public String getE_mail() {
        return eMail;
    }

    public void setE_mail(String e_mail) {
        this.eMail= eMail;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public String geteMail() {
        return eMail;
    }

    public Set<Menadzer> getMenadzeri() {
        return menadzeri;
    }

    public Set<Sala> getSale() {
        return sale;
    }
}
