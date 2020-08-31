package com.example.model.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ListaProjekcija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;
    @Column
    private String zanr;
    @Column
    private String pocetak;
    @Column
    private String dan;
    @Column
    private String cena;
    @Column
    private int brojRezervisanih;




    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Film film;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Gledalac> gledaoci=new ArrayList<>();

    public ListaProjekcija() {

    }



    public ListaProjekcija(Long id, String naziv, String zanr, String pocetak, String dan, String cena) {
        this.id = id;
        this.naziv = naziv;
        this.zanr = zanr;
        this.pocetak = pocetak;
        this.dan = dan;
        this.cena = cena;
    }
    public ListaProjekcija(String naziv, String zanr, String pocetak, String dan, String cena) {
        this.naziv = naziv;
        this.zanr = zanr;
        this.pocetak = pocetak;
        this.dan = dan;
        this.cena = cena;
    }

    public ListaProjekcija(String naziv, String zanr, String pocetak, String dan, String cena, Sala sala, Film film) {
        this.naziv = naziv;
        this.zanr = zanr;
        this.pocetak = pocetak;
        this.dan = dan;
        this.cena = cena;
        this.sala = sala;
        this.film = film;
    }

    public int getBrojRezervisanih() {
        return brojRezervisanih;
    }

    public void setBrojRezervisanih(int brojRezervisanih) {
        this.brojRezervisanih = brojRezervisanih;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }



    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public void setPocetak(String pocetak) {
        this.pocetak = pocetak;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getZanr() {
        return zanr;
    }

    public String getPocetak() {
        return pocetak;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public List<Gledalac> getGledaoci() {
        return gledaoci;
    }

    public void setGledaoci(List<Gledalac> gledaoci) {
        this.gledaoci = gledaoci;
    }



    public ListaProjekcija(Long id, String naziv, String zanr, String pocetak, String dan, String cena, Sala sala, Film film, List<Gledalac> gledaoci) {
        this.id = id;
        this.naziv = naziv;
        this.zanr = zanr;
        this.pocetak = pocetak;
        this.dan = dan;
        this.cena = cena;
        this.sala = sala;
        this.film = film;
        this.gledaoci = gledaoci;
    }


    @Override
    public String toString() {
        return "ListaProjekcija{" +
                "film='" + film + '\'' +
                ", dan='" + dan + '\'' +
                ", cena='" + cena + '\'' +
                '}';
    }







    public Sala getSalas() {
        return sala;
    }

    public void setSalas(Sala salas) {
        this.sala = salas;
    }
}
