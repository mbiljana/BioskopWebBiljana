package com.example.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;
    @Column
    private String opis;
    @Column
    private String zanr;
    @Column
    private Time trajanje;
    @Column
    private Double ocena;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ListaProjekcija> lista_projekcija = new HashSet<ListaProjekcija>();


    public Film() {

    }


    public Film(Long id, String naziv, String opis, String zanr, Time trajanje, Double ocena, Set<ListaProjekcija> projekcija) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.ocena = ocena;
        this.lista_projekcija = projekcija;
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

    public Time getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Time trajanje) {
        this.trajanje = trajanje;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", zanr='" + zanr + '\'' +
                ", trajanje=" + trajanje +
                ", ocena=" + ocena +
                '}';
    }
}
