package com.example.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ocena implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double ocena;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Gledalac gledalac;

    public Ocena() {

    }


    public Ocena(Long id, double ocena, Film film, Gledalac gledalac) {
        this.id = id;
        this.ocena = ocena;
        this.film = film;
        this.gledalac = gledalac;
    }
    public Ocena( double ocena, Film film, Gledalac gledalac) {
        this.ocena = ocena;
        this.film = film;
        this.gledalac = gledalac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Gledalac getGledalac() {
        return gledalac;
    }

    public void setGledalac(Gledalac gledalac) {
        this.gledalac = gledalac;
    }
}
