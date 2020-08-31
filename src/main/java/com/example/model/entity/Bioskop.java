package com.example.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @Column
    private String eMail;


    @ManyToMany
    @JoinTable(name = "filmoviBioskop",
            joinColumns = @JoinColumn(name = "bioskop_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
    private Set<Film> filmoviBioskop=new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Menadzer menadzer;

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    @OneToMany(mappedBy = "bioskop",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Sala> sale = new ArrayList<>();



    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ListaProjekcija> listaProjekcija=new HashSet<>();



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
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.eMail=eMail;
    }

    public Bioskop(String naziv, String adresa, String brojTelefonaCentrale, String eMail, Menadzer menadzer) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.eMail=eMail;
        this.menadzer= menadzer;
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

    public void setSale(List<Sala> sale) {
        this.sale = sale;
    }

    public String geteMail() {
        return eMail;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public List<Sala> getSale() {
        return sale;
    }
}
